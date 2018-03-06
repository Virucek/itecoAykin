package pages;

import cucumber.api.java.en_old.Ac;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AccountPlanCO extends Base {

    public AccountPlanCO(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "accountPlanCO";
    }

    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[@class='active ng-binding ng-scope']")
    public WebElement tableTitle;

    @FindBy(how = How.XPATH, using = "//td[@id='accountplancogrid_toppager_left']//td")
    public List<WebElement> tableButtons;

    @FindBy(how = How.XPATH, using = "//td[@aria-describedby='accountplancogrid_balanceAccountNum']")
    public List<WebElement> accounts;

    public void checkElementPage(String elemText) throws InterruptedException {
        checkElement(tableTitle,elemText);
    }

    public void clickOnTableButton(String elemText){
        clickElement(tableButtons, elemText);
    }

    public void checkAccount(String elemText){
        checkPresenceOfElements(accounts, elemText);
    }
}
