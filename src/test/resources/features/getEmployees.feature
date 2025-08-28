Feature: Get list of employees from Dummy API

    Scenario: Verify the employee list is returned successfully
        Given I set the API endpoint to "https://dummy.restapiexample.com/api/v1/employees"
        When I send a GET request
        Then the response status code should be 200
        And the response should contain a list of employees
