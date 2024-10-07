import org.testng.annotations.Test;

public class GetAfterDeleteTests {
    @Test(priority = 4)
    public void getBoard() {
        Board.get().then().log().all().statusCode(404);
    }

    @Test(priority = 3)
    public void getList() {
        List.get().then().log().all().statusCode(404);
    }

    @Test(priority = 2)
    public void getLabel() {
        Label.get().then().log().all().statusCode(404);
    }

    @Test(priority = 1)
    public void getCard() {
        Card.get().then().log().all().statusCode(404);
    }
}
