Feature: User needs to validate google maps API

@Addplace
Scenario Outline: User to add place in Google Maps API
Given User needs to Add place payload with "<name>" "<phonenumber>" "<address>"
When User needs to "addplace" using "post" http request
Then User needs to validate if status code is 200
And User needs to validate the response body and check "status" is "OK"
And User needs to validate the response body and check "scope" is "APP"
And user needs to maps to "<name>" and need to "getplace" the request

Examples:
|name            |phonenumber|address            |
|naveensuperhouse|90848474939|super task street  |
# |someoneshouse   |90810927384|super dupper street|

@Deleteplace
Scenario: User to delete  place in Google Maps API
Given User needs to add delete place payload
When User needs to "deleteplace" using "post" http request
Then User needs to validate if status code is 200
And User needs to validate the response body and check "status" is "OK"
