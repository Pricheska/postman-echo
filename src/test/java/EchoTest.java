import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EchoTest {
    @Test
    public void shouldReturnName() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("name:Denis") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("name:Denis"))
        ;
    }
    @Test
    public void shouldReturnId() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("id:20544") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("id:20544"))
        ;
    }
    @Test
    void ShouldReturnCurrency () {
        given()
                .baseUri("https://postman-echo.com")
                .body("USD")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("USD"))
                ;
    }

}
