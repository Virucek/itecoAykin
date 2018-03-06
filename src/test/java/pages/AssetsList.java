package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AssetsList extends Base{

    public AssetsList (WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "assetsList";
    }

    @FindBy(how = How.XPATH,using = "//ol[@class='breadcrumb']//*")
    public WebElement formTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='top-buttons']//button")
    private List<WebElement> topButtons;

    @FindBy(how = How.XPATH, using = "//td[@id='assetgrid_toppager_left']//td")
    private List<WebElement> tableButtons;

    @FindBy(how = How.XPATH, using = "//td[@aria-describedby='assetgrid_accountNum']")
    private List<WebElement> accounts;

     public void checkElementPage(String elemText) throws InterruptedException {
        checkElement(formTitle, elemText);
    }

    public void clickTopButton (String elemText) {
        clickOnListOfElementsBreak(topButtons, elemText);
    }

    public void clickOnTableButton(String elemText){
        clickElement(tableButtons, elemText);
    }

    public void checkAccount(String elemText){
        checkPresenceOfElements(accounts, elemText);
    }

}
