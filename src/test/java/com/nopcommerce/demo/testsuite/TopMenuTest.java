package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComponentsPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LaptopsAndNoteBooksPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();

    LaptopsAndNoteBooksPage LaptopsAndNotebooksPage= new LaptopsAndNoteBooksPage();
    ComponentsPage componentPage= new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllDesktops";
        homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu(menuName);
        String expectedMessage = "Desktops";
        String actualMessage = desktopPage.getDesktopText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoverAndClickOnLaptopAndNoteBooks();
        homePage.selectMenu(menuName);
        String expectedMessage = "Laptops & Notebooks";
        String actualMessage = LaptopsAndNotebooksPage.getLaptopsAndNotebooksText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllComponents";
        homePage.mouseHoverAndClickOnComponent();
        homePage.selectMenu(menuName);
        String expectedMessage = "Components";
        String actualMessage = componentPage.getComponentText();
        Assert.assertEquals(expectedMessage, actualMessage);
}

}
