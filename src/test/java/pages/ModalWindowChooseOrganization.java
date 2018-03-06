package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ModalWindowChooseOrganization extends Base{

    public String getTitle() {
        return "launchPage";
    }

    public ModalWindowChooseOrganization(WebDriver driver){
            super(driver);
        }

    @FindBy(how = How.XPATH, using = "//h4[@id='organizationModalLabel']")
    public WebElement modalOrgName;

    @FindBy(how = How.XPATH, using = "//td[@aria-describedby='organizationgrid_shortName']")
    public List<WebElement> orgName;

    @FindBy(how = How.XPATH, using = "//self::node()[text()='Выбрать']")
    public WebElement chooseButton;

    public void chooseOrgName(String elemText){
        clickOnListOfElements(orgName, elemText);
    }

    public void clickButton(String elemText){
        clickButton(chooseButton, elemText);
    }

    public void checkElement(String elemText) throws InterruptedException {
        checkElement(modalOrgName, elemText);
    }

    public void checkClosedElement(String elemText) throws Throwable {
        checkClosedElement(modalOrgName, elemText);
    }
}
