Feature: Validating Place API's

Scenario Outline: Verify if Place is being Successfully added using AddPlacAPI

Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "Post" request
Then the API call got sucess with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
 |name           |language|address        |
 |A.House        |English |Dublin, ca     |
 |Frontline house|French  |29, side layout|