package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CreateAssetsStep1 extends Base {

    public CreateAssetsStep1 (WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "briefAssetCard";
    }

    @FindBy(how = How.XPATH, using = "(//ol[@class='breadcrumb']//li)[2]")
    private WebElement formTitle;

    @FindBy(how = How.XPATH, using = "//form[@name='cardForm']//label[@class='control-label']")
    private List<WebElement> fields;

    @FindBy(how = How.XPATH, using = "//input[@name='orgName']")
    private WebElement orgName;

    @FindBy(how = How.XPATH, using = "//div/select[@name = 'assetFunctionalType']/option")
    private List<WebElement> dropDownFunctionalTypes;

    @FindBy(how = How.XPATH, using = "//div/button[text()='Далее']")
    private WebElement nextButton;

    public void checkElementPage(String elemText) throws InterruptedException {
        checkElement(formTitle, elemText);
    }

    public void checkField(String elemText) throws InterruptedException{
        checkListOfElements(fields, elemText);
    }

    public void checkFieldIsDisabled(){
        checkElementIsDisabled(orgName);
    }

    public void chooseOptionTypeAsset(String elemText){
        clickOnListOfElementsBreak(dropDownFunctionalTypes, elemText);
    }

    public void clickNextButton(String elemText){
        clickButton(nextButton, elemText);
    }
}
