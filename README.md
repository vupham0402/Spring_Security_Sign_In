# Spring_Security_Sign_In
## Feature
   - The user's email and password will be authenticated based on the MySQL database, and if the account exists, a token and refresh-token will be generated
   - The token will be validated every time user wants to access the test page
   - If the token is expired, the refresh token will be authenticated on the refresh page to generate a new token and refresh-token
## How to run 
   - In application.yml file, MySQL server, username, and password should be change to match with your local
## Postman
### Token
![token](https://user-images.githubusercontent.com/60011958/219829339-a2b7d7bb-be33-4aa5-92fd-0db2e6a15efe.PNG)
### Refresh-token
![refresh-token](https://user-images.githubusercontent.com/60011958/219829347-a873b60c-a92f-4d05-bd05-03244e7a5f7c.PNG)
### Test page
![test](https://user-images.githubusercontent.com/60011958/219829361-45d0cdff-80f1-4cf1-9c6d-3f8dc792579d.PNG)
