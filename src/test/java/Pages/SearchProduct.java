package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProduct {
    WebDriver driver;
    @FindBy(id = "search_query_top")
    WebElement txtSearch;
    @FindBy(name = "submit_search")
    WebElement btnSearch;
    @FindBy(xpath = "//span[@class='lighter']")
    WebElement lblSearchedItem;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void searchItem(String itemname) throws InterruptedException {
        txtSearch.sendKeys(itemname);
        Thread.sleep(2000);
        btnSearch.click();
        Assert.assertEquals(lblSearchedItem.getText().replace("\"", ""),itemname.toUpperCase());
    }
}
