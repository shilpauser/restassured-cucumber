package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetEmployeesSteps {

    private String endpoint;
    private Response response;

    @Given("I set the API endpoint to {string}")
    public void i_set_the_api_endpoint_to(String url) {
        endpoint = url;
    }

    @When("I send a GET request")
    public void i_send_a_get_request() {
        response = given()
                        .when()
                        .get(endpoint)
                        .then()
                        .extract()
                        .response();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain a list of employees")
    public void the_response_should_contain_a_list_of_employees() {
        response.then().body("data", not(empty()));
    }
}
