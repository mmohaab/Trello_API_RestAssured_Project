import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Board {

    private static String boardID;

    public static String getBoardID() {
        return boardID;
    }

    public static Response  create(String boardName) {
        Response response = Base.request
                .queryParam("name", boardName)
                .when().post("boards");
        boardID = response.jsonPath().getString("id");
        return response;
    }

    public static Response get() {
        return Base.request
                .when().get("boards/" + boardID);
    }

    public static Response edit(String boardName) {
        return Base.request
                .queryParam("name", boardName)
                .when().put("boards/" + boardID);
    }

    public static Response delete() {
        return Base.request
                .when().delete("boards/" + boardID);
    }

}
