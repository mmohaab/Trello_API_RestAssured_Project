import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetAfterPutTests {
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    public void updateBoard() {
        var response = Board.get().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),Board.getNewBoardName());
        softAssert.assertEquals(response.path("id"),Board.getBoardID());
    }

    @Test(priority = 3)
    public void updateList() {
        var response = List.get().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),List.getListNewName());
        softAssert.assertEquals(response.path("id"),List.getListID());
        softAssert.assertEquals(response.path("idBoard"),Board.getBoardID());
    }

    @Test(priority = 2)
    public void updateLabel() {
        var response = Label.get().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("name"),Label.getLabelNewName());
        softAssert.assertEquals(response.path("id"),Label.getLabelID());
        softAssert.assertEquals(response.path("color"),Label.getLabelNewColor());
        softAssert.assertEquals(response.path("idBoard"),Board.getBoardID());
    }

    @Test(priority = 4)
    public void updateCard() {
        var response = Card.get().then().log().all().statusCode(200).extract().response();
        softAssert.assertEquals(response.path("idBoard"),Board.getBoardID());
        softAssert.assertEquals(response.path("idList"),List.getListID());
        softAssert.assertEquals(response.path("id"),Card.getCardID());
        softAssert.assertEquals(response.path("name"),Card.getCardName());
    }
}
