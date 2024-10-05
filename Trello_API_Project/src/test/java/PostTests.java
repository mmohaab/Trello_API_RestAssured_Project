import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.hamcrest.Matchers.*;

public class PostTests {
    @Test
    public void createBoard() {
        String boardName = "Board 1";
        Board.create(boardName).then().log().all().statusCode(200)
                .body("name", equalTo(boardName))
                .body("id", notNullValue());
    }
    @Test(dependsOnMethods = "createBoard")
    public void createLabel() {
        String labelName = "Label 1";
        String color = "blue";
        Label.create(labelName,color).then().log().all().statusCode(200)
                .body("name", equalTo(labelName))
                .body("color",equalTo(color))
                .body("id", notNullValue())
                .body("idBoard",equalTo(Board.getBoardID()));
    }
    @Test(dependsOnMethods = "createBoard")
    public void createList() {
        String listName = "List 1";
       List.create(listName).then().log().all().statusCode(200)
               .body("name", equalTo(listName))
               .body("id", notNullValue())
               .body("idBoard",equalTo(Board.getBoardID()));
    }
    @Test(dependsOnMethods = "createList")
    public void createCard() {
        Card.create().then().log().all().statusCode(200)
                .body("id", notNullValue())
                .body("idBoard",equalTo(Board.getBoardID()))
                .body("idList",equalTo(List.getListID()));
    }
}
