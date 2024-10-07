import io.restassured.response.Response;

public class Label extends Base {

    private static String labelID;

    public static String getLabelID() {
        return labelID;
    }

    public static Response create(String LabelName, String color) {
        Response response = request
                .queryParams("name", LabelName,
                        "color", color,
                        "idBoard", Board.getBoardID())
                .when().post("labels");
        labelID = response.path("id");
        return response;
    }

    public static Response get() {
        return request
                .when().get("labels/" + labelID);
    }

    public static Response edit(String LabelName, String color) {
        return request
                .queryParams("name", LabelName,
                        "color", color)
                .when().put("labels/" + labelID);
    }

    public static Response delete() {
        return request
                .when().delete("labels/" + labelID);
    }

}