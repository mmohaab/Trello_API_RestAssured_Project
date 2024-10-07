import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.Matchers.*;

public class PostTests {
    @BeforeMethod
    public void setup() {
        Board.setBoardName("Board 1");
        List.setListName("List 1");
        Label.setLabelName("Label 1");
        Label.setLabelColor("red");
    }

    @Test(priority = 1)
    public void createBoard() {
        Board.create().then().log().all().statusCode(200)
                .body("name", equalTo(Board.getBoardName()))
                .body("id", notNullValue());
    }

    @Test(priority = 3)
    public void createList() {
        List.create().then().log().all().statusCode(200)
                .body("name", equalTo(List.getListName()))
                .body("id", notNullValue())
                .body("idBoard", equalTo(Board.getBoardID()));
    }

    @Test(priority = 2)
    public void createLabel() {
        Label.create().then().log().all().statusCode(200)
                .body("name", equalTo(Label.getLabelName()))
                .body("color", equalTo(Label.getLabelColor()))
                .body("id", notNullValue())
                .body("idBoard", equalTo(Board.getBoardID()));
    }

    @Test(priority = 4)
    public void createCard() {
        Card.create().then().log().all().statusCode(200)
                .body("id", notNullValue())
                .body("idBoard", equalTo(Board.getBoardID()))
                .body("idList", equalTo(List.getListID()));
    }
}
