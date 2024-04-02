package searchingTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import testBase.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchingTest extends TestBase {
    protected WebDriverWait wait;
    @BeforeMethod
    public void setUpWait(){
         wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }


    @Test
    public void searchResultsShouldBeRelevantToSearchQuery(){
        String searchText = "Macbook".toLowerCase();
        homePage.enterTextInSearchField(searchText);
        SearchResultPage searchResultPage = homePage.clickOnSearchBtn();
        Assert.assertTrue(searchResultPage.getSearchResultsText().toLowerCase().contains(searchText));
    }


    @Test
    public void sortSearchResultsByNameAscending(){
        homePage.hoverOnComputerNav();
        SearchResultPage searchResultPage = homePage.clickOnNotebooksNav();
        searchResultPage.selectSortType("Name: A to Z");
        searchResultPage.getProductNames();
        searchResultPage.getAndSortProductNamesAscending();
        Assert.assertEquals(searchResultPage.getProductNames(), searchResultPage.getSortedProductNames());
    }

    @Test
    public void sortSearchResultsByNameDescending(){
        homePage.hoverOnComputerNav();
        SearchResultPage searchResultPage = homePage.clickOnNotebooksNav();
        searchResultPage.selectSortType("Name: Z to A");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(searchResultPage.getLoadingAfterSort()));
        searchResultPage.getAndSortProductNamesDescending();
        Assert.assertEquals(searchResultPage.getProductNames(), searchResultPage.getSortedProductNames());
    }

    @Test
    public void sortSearchResultsByPriceAscending(){
        homePage.hoverOnComputerNav();
        SearchResultPage searchResultPage = homePage.clickOnNotebooksNav();
        searchResultPage.selectSortType("Price: Low to High");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(searchResultPage.getLoadingAfterSort()));
        searchResultPage.getAndSortProductPricesAscending();
        Assert.assertEquals(searchResultPage.getProductPrices(), searchResultPage.getSortedProductPrices());
    }

    @Test
    public void sortSearchResultsByPriceDescending(){
        homePage.hoverOnComputerNav();
        SearchResultPage searchResultPage = homePage.clickOnNotebooksNav();
        searchResultPage.selectSortType("Price: High to Low");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(searchResultPage.getLoadingAfterSort()));
        searchResultPage.getAndSortProductPricesDescending();
        Assert.assertEquals(searchResultPage.getProductPrices(), searchResultPage.getSortedProductPrices());
    }

    @Test
    public void changePricesCurrency(){
        homePage.hoverOnComputerNav();
        SearchResultPage searchResultPage = homePage.clickOnNotebooksNav();
        List<Double> oldCurrencyPrice = new ArrayList<>(searchResultPage.getProductPricesList());
        String oldCurrencySymbol = searchResultPage.getPriceSymbol();
        searchResultPage.selectCurrency("Euro");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(searchResultPage.getLoadingAfterSort()));
        String newCurrencySymbol = searchResultPage.getPriceSymbol();
        List<Double> newCurrencyPrice = new ArrayList<>(searchResultPage.getProductPricesList());
        Assert.assertNotEquals(oldCurrencyPrice, newCurrencyPrice);
        Assert.assertNotEquals(oldCurrencySymbol, newCurrencySymbol);
    }


}
