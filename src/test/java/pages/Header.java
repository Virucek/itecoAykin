package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Header extends Base {

    public Header (WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "assetsList";
    }

    @FindBy(how = How.XPATH, using = "//img[@class='logo']")
    public WebElement logo;

    @FindBy(how = How.XPATH, using = "//span[@ng-bind='showOrgName()']")
    public WebElement orgName;

    @FindBy(how = How.XPATH, using = "//li[@class='dropdown']/a")
    public List<WebElement> dropDownButtons;

    @FindBy(how = How.XPATH, using = "//li[contains(@class, 'dropdown')]/ul[contains(@class,'menu')]/li/a")
    public List<WebElement> option;

    @FindBy(how = How.XPATH, using = "//li[contains(@class,'dropdown')]//ul[@class='dropdown-menu']/li/a")
    public WebElement exitButton;

    public void checkLogoName(String elemText){
        checkElementTitle(logo, elemText);
    }

    public void checkOrgName(String elemText) throws InterruptedException {
        checkElement(orgName, elemText);
    }

    public void clickDropDownButton(String elemText){
        clickOnListOfElements(dropDownButtons, elemText);
    }

    public void chooseOption(String elemText){
        clickOnListOfElements(option, elemText);
    }

    public void clickExitButton(String elemText){
        clickButton(exitButton,elemText);
    }
}
