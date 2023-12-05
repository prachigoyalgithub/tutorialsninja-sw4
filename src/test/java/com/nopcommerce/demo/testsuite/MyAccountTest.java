package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.MyAccountsPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class MyAccountTest extends BaseTest {
    String email;
    MyAccountsPage myAccountPage = new MyAccountsPage();
    RegisterPage registerPage = new RegisterPage();

    LoginPage loginPage = new LoginPage();

    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Register Account";
        String actualMessage = registerPage.getRegisterAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Returning Customer";
        String actualMessage = loginPage.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String option = "Register";
        myAccountPage.selectMyAccountOptions(option);
        registerPage.enterFirstName("Prime");
        registerPage.enterLastName("Testing");
        registerPage.enterEmail(email);
        registerPage.enterPhoneNumber("9898989898");
        registerPage.enterPassword("Admin@123");
        registerPage.enterConfirmPassword("Admin@123");
        registerPage.selectSubscribeButton("Yes");
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();

        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = registerPage.getAccountCreatedText();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        loginPage.enterEmailId("admin123456@gmail.com");
        loginPage.enterPassword("Admin@123");
        loginPage.clickOnLogin();
        String expectedMessage = "My Account";
        String actualMessage = homePage.getMyAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}



