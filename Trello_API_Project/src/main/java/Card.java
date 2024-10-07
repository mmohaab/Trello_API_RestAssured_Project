import io.restassured.response.Response;

public class Card extends Base{

    private static String cardID;

    public static String getCardID() {
        return cardID;
    }

    public static Response create() {
        Response response = request
                .queryParam("idList", List.getListID())
                .when().post("cards");
        cardID = response.path("id");
        return response;
    }

    public static Response get() {
        return request
                .when().get("cards/" + cardID);
    }

    public static Response edit(String cardName) {
        return request
                .queryParam("name", cardName)
                .when().put("cards/" + cardID);
    }

    public static Response delete() {
        return request
                .when().delete("cards/" + cardID);
    }

}
