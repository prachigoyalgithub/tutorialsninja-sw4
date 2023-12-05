package com.nopcommerce.demo.testsuite;


import com.nopcommerce.demo.pages.CheckOutPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LaptopsAndNoteBooksPage;
import com.nopcommerce.demo.pages.ShoppingCartPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage = new HomePage();
    LaptopsAndNoteBooksPage LaptopsAndNotebooksPage = new LaptopsAndNoteBooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoverAndClickOnLaptopAndNoteBooks();
        homePage.selectMenu(menuName);
        String exceptedMessage = LaptopsAndNotebooksPage.beforeSortPriceHighToLow().toString();
        String actualMessage = LaptopsAndNotebooksPage.afterSortPriceHighToLow().toString();
        Assert.assertEquals(exceptedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoverAndClickOnLaptopAndNoteBooks();
        homePage.selectMenu(menuName);
        LaptopsAndNotebooksPage.sorttByFilter("Price (High > Low)");
        LaptopsAndNotebooksPage.selectProduct("MacBook");

        String expectedMessage = "MacBook";
        String actualMessage = LaptopsAndNotebooksPage.getMacBookText();
        Assert.assertEquals(expectedMessage, actualMessage);

        LaptopsAndNotebooksPage.clickOnAddToCart();
        expectedMessage = "Success: You have added MacBook to your shopping cart!\n";
        actualMessage = LaptopsAndNotebooksPage.getSuccessText();
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);

        LaptopsAndNotebooksPage.clickOnShoppingCartLink();

        expectedMessage = "Shopping Cart  (0.00kg)";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "MacBook";
        actualMessage = shoppingCartPage.getMackBookText();
        Assert.assertEquals(expectedMessage, actualMessage);
        shoppingCartPage.clearField();


        shoppingCartPage.updateQuantity("2");

        expectedMessage = "Success: You have modified your shopping cart!\n";
        actualMessage = shoppingCartPage.getSuccessText();
        String[] actualmsg1 = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg1[0]);

        shoppingCartPage.clickCurrencyDropDown();
        shoppingCartPage.clickPoundSterling();

        expectedMessage = "£737.45";
        actualMessage = shoppingCartPage.getMackBookPriceText();
        Assert.assertEquals(expectedMessage, actualMessage);

        shoppingCartPage.clickOnCheckOutButton();

        expectedMessage = "Checkout";
        actualMessage = checkOutPage.getCheckOutText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "New Customer";
        actualMessage = checkOutPage.getNewCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);

        checkOutPage.clickOnGuestCheckOut();
        checkOutPage.clickOnContinueButton();
        checkOutPage.enterFirstName("Prime");
        checkOutPage.enterLastName("Testing");
        checkOutPage.enterEmail("primetesting@gmail.com");
        checkOutPage.enterPhoneNumber("9898989898");
        checkOutPage.enterAddress1("Mehsana");
        checkOutPage.enterCity("Tintodan");
        checkOutPage.enterPostCode("382865");
        checkOutPage.selectCountry("Australia");
        checkOutPage.selectRegion("Queensland");
        checkOutPage.clickOnGuestContinue();
        checkOutPage.enterComments("My mackBook");
        checkOutPage.clickOnAgree();

        expectedMessage = "Warning: No Payment options are available. Please contact us for assistance!";
        actualMessage = checkOutPage.getPaymentWarningText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
