import io.restassured.response.Response;

public class Board extends Base {

    private static String boardID;

    public static String getBoardID() {
        return boardID;
    }

    public static Response create(String boardName) {
        Response response = request
                .queryParam("name", boardName)
                .when().post("boards");
        boardID = response.jsonPath().getString("id");

        return response;
    }

    public static Response get() {
        return request
                .when().get("boards/" + boardID);
    }

    public static Response edit(String boardName) {
        return request
                .queryParam("name", boardName)
                .when().put("boards/" + boardID);
    }

    public static Response delete() {
        return request
                .when().delete("boards/" + boardID);
    }

}
