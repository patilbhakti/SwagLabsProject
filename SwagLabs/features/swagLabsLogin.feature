
Feature: to verify the login with the multiple data in swag labs login page

Scenario Outline: to verify the login page of swag labs
Given launch swag labs application
When login to the application with valid or invalid "<username>" and "<password>" 
Then order a product from item list and enter valid information
Then validate the homepage

Examples:

|username|password|                        
|abc@gmail.com|123456|                     
|standard_user|7697897|
|ria@gmail.com|secret_sauce|
|standard_user|secret_sauce|

















