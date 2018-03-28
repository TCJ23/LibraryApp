package crud.user.web;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import crud.BaseIT;
import crud.user.CreateUserDto;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class UserControllerTest extends BaseIT {



    @Test
    public void shouldCreateNewUser() {
        //given
        CreateUserDto hello = new CreateUserDto("hello");
        RequestSpecification request = RestAssured.given()
                .body(hello);
        //when
        Response response = request
                .when()
                .header("content-type","application/json")
                .post(USER_API_URL);
        //then
        response.then()
                .statusCode(200);

    }

    @Test
    public void shouldReturnUser() {
        //given
        int userId = 100;
        RequestSpecification request = RestAssured.given();
        //when
        Response response = request
                .when()
                .get(USER_API_URL + "/" + userId);
        //then
        response.then()
                .statusCode(200)
                .body("firstname", IsEqual.equalTo("George"))
                .body("lastname", IsEqual.equalTo("Martin"))
                .body("username", IsEqual.equalTo("grrm"))
                .body("email", IsEqual.equalTo("grrm@gft.com"));
    }
}