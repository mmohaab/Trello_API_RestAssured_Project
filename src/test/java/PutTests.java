import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PutTests {
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
        Board.setNewBoardName("Board 2");
        List.setListNewName("List 2");
        Label.setLabelNewName("Label 2");
        Label.setLabelNewColor("blue");
        Card.setCardName("Updated Card");
    }

    @Test(priority = 1)
    public void updateBoard() {
        var response = Board.update().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),Board.getNewBoardName());
    }

    @Test(priority = 3)
    public void updateList() {
        var response = List.update().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),List.getListNewName());
    }

    @Test(priority = 2)
    public void updateLabel() {
        var response = Label.update().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),Label.getLabelNewName());
        softAssert.assertEquals(response.path("color"),Label.getLabelNewColor());
    }

    @Test(priority = 4)
    public void updateCard() {
        var response = Card.update().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),Card.getCardName());
    }
}
