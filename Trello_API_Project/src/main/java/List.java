import io.restassured.response.Response;

public class List extends Base{

    private static String listID;

    public static String getListID() {
        return listID;
    }

    public static Response create(String listName) {
        Response response = request
                .queryParam("name", listName)
                .queryParam("idBoard", Board.getBoardID())
                .when().post("lists");
        listID = response.path("id");
        return response;
    }

    public static Response get() {
        return request
                .when().get("lists/" + listID);
    }

    public static Response edit(String listName) {
        return request
                .queryParam("name", listName)
                .when().put("lists/" + listID);
    }

}
