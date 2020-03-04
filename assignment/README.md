# Digital-Authentication

Spring Security using JWT (Json Web Token) in Spring Boot

This Project uses JWT to secure the REST Response end points for authentication.
This Project will display the campaigns details.



#### Version ####

`1.0.0`

## Summary ##

It refers to the scenario where the system requests the user to authenticate themselves and sign. The user will be requested to enter the login username & password, which will be validated by the system.Per user secure response will generate 

Getting started:

* [Prerequisites](#markdown-header-prerequisites)
* [Configuration](#markdown-header-configuration)
* [Contact](#markdown-header-authors)


### Prerequisites

- Git - only for cloning project from repository
- Apache Maven (3.3.9 or higher)


### Configuration

There are multiple ways to provide below configuration.

* For **local** execution, one can change **application.properties**
* For **CF** deployment, one can bind corresponding CF services, which would in turn set these parameters

### Back End:

## SWAGGER

Depends on the swagger spec 1.0.0 going to send the payload to UI.
Swagger Spec Link – It is free trial version Valid till 5th March 2020
https://app.swaggerhub.com/apis/campaign8/RestValidationAPI/1.0.0#/trial

## ELASTIC SEARCH

elastic search link – It is free trail version Valid till 5th March 2020
Username : elastic
Password: uDgQGECREeLx79ZCjrrQSi5j
URL : https://404969a55c184776a05fefdadafa6a89.ap-northeast-1.aws.found.io:9243
https://404969a55c184776a05fefdadafa6a89.ap-northeast-1.aws.found.io:9243/_cat/indices?v
https://404969a55c184776a05fefdadafa6a89.ap-northeast1.aws.found.io:9243/assignment/campaings/_search?pretty

## BACKEND URL's:

Openshift is free trail version Valid till 5th March 2020
http://assignment-campaigns-api-assignmentcampaigns.apps.us-west-1.starter.openshiftonline.com/rubiya/campaigns/all
http://assignment-campaigns-api-assignmentcampaigns.apps.us-west-1.starter.openshiftonline.com/rubiya/campaigns/completed
http://assignment-campaigns-api-assignmentcampaigns.apps.us-west-1.starter.openshiftonline.com/rubiya/campaigns/ongoing
http://assignment-campaigns-api-assignmentcampaigns.apps.us-west-1.starter.openshiftonline.com/rubiya/campaigns/historical?historical=Flim Campaign

### Openshift Deployment
Refer following automation yml files
${project.basedir}\digital-authentication\deployment

### Contact

## Author
**rubiya.kadarbasha*

## Author Mail Id
**rubiyakadarbasha@gmail.com**
