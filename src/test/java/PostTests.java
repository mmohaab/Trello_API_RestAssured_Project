import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.PriorityQueue;

import static org.hamcrest.Matchers.*;

public class PostTests {
    @Test(priority = 1)
    public void createBoard() {
        String boardName = "Board 1";
        Board.create(boardName).then().log().all().statusCode(200)
                .body("name", equalTo(boardName))
                .body("id", notNullValue());
    }
    @Test(priority = 2)
    public void createList() {
        Board.create("board");
        String listName = "List 1";
        List.create(listName).then().log().all().statusCode(200)
                .body("name", equalTo(listName))
                .body("id", notNullValue())
                .body("idBoard",equalTo(Board.getBoardID()));
    }
    @Test(priority = 3)
    public void createLabel() {
        String labelName = "Label 1";
        String color = "blue";
        Label.create(labelName,color).then().log().all().statusCode(200)
                .body("name", equalTo(labelName))
                .body("color",equalTo(color))
                .body("id", notNullValue())
                .body("idBoard",equalTo(Board.getBoardID()));
    }
    @Test(priority = 4)
    public void createCard() {
        Card.create().then().log().all().statusCode(200)
                .body("id", notNullValue())
                .body("idBoard",equalTo(Board.getBoardID()))
                .body("idList",equalTo(List.getListID()));
    }
}
