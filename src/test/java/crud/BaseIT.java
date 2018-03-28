package crud;

import com.jayway.restassured.RestAssured;
import crud.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIT {

    public static final String USER_API_URL = "http://localhost/users";
    public static final String BOOK_API_URL = "http://localhost/books";
    public static final String BOOKING_API_URL = "http://localhost/bookings";

    @LocalServerPort
    private int port;

    @Before
    public void init(){
        RestAssured.port = port;
    }

}