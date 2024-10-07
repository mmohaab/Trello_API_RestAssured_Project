import org.testng.annotations.Test;

public class DeleteTests {

    @Test(priority = 4)
    public void deleteBoard() {
        Board.delete().then().log().all().statusCode(200);
    }

    @Test(priority = 2)
    public void deleteLabel() {
        Label.delete().then().log().all().statusCode(200);
    }

    @Test(priority = 1)
    public void deleteCard() {
        Card.delete().then().log().all().statusCode(200);
    }
}
