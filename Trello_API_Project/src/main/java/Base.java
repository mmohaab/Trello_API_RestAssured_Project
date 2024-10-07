import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Base {
    private static final String key = "7e1ec8d7d69193702f852dd1c88210da";
    private static final String token = "ATTA1461b32099bcad388698fd3e6af8c02806dd1de7d5d32622736e280ca7231df424E7500F";
    protected static RequestSpecification request =
            given().log().all()
                .baseUri("https://api.trello.com/1/")
                .queryParams("key", key, "token", token)
                .contentType("application/json");
}
