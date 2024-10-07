import io.restassured.response.Response;

public class Label {

    private static String labelID;

    public static String getLabelID() {
        return labelID;
    }

    public static Response create(String LabelName, String color) {
        Response response = Base.request
                .queryParam("name", LabelName)
                .queryParam("color", color)
                .queryParam("idBoard"," Board.getBoardID()")
                .when().post("labels");
        labelID = response.path("id");
        return response;
    }

    public static Response get() {
        return Base.request
                .when().get("labels/" + labelID);
    }

    public static Response edit(String LabelName, String color) {
        return Base.request
                .queryParams("name", LabelName,
                        "color", color)
                .when().put("labels/" + labelID);
    }

    public static Response delete() {
        return Base.request
                .when().delete("labels/" + labelID);
    }

}