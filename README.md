# Spring_Security_Sign_In
## Feature
   - The user's email and password will be authenticated based on the MySQL database, and if the account exists, a token and refresh-token will be generated
   - The token will be validated every time user wants to access the test page
   - If the token is expired, the refresh token will be authenticated on the refresh page to generate a new token and refresh-token
## How to run 
   - In application.yml file, MySQL server, username, and password should be change to match with your local
## Postman
### Token
### Refresh-token
### Test page
