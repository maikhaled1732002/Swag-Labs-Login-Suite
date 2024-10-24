SwagLogin Validator
This project automates the validation of the login page at SauceDemo using Selenium WebDriver and TestNG. It verifies the proper functionality of the login form under various scenarios, ensuring that both valid and invalid login attempts behave as expected.
________________________________________
Project Structure
The TestsRequired class includes five automated test cases:
1.	UI Elements Presence Check
Ensures that the username field, password field, and login button are present on the main screen.
Test Method: aTest1
2.	Valid Credentials Test
Verifies that logging in with valid credentials (Username: standard_user & Password: secret_sauce) leads to successful login.
Test Method: bTest2
3.	Invalid Credentials Test
Checks that the login form displays the correct error message for invalid username and password combinations.
Test Method: cTest3
4.	Empty Username Test
Tests the behavior when the username is left empty, confirming the correct error message is displayed.
Test Method: dTest4
5.	Empty Password Test
Tests the behavior when the password is left empty, ensuring the correct error message is shown.
Test Method: eTest5
________________________________________
Technologies Used
•	Java
•	Selenium WebDriver
•	TestNG
•	WebDriverManager

