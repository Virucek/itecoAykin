package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ModalWindowSearchTableAccount extends Base {

    public ModalWindowSearchTableAccount(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "accountPlanCO";
    }

    @FindBy(how = How.XPATH, using = "//div[@id='searchhdfbox_accountplancogrid']//span[text()='Поиск...']")
    private WebElement searchModalPage;

    @FindBy(how = How.XPATH, using = "//td[@class='columns']/select/option")
    private List<WebElement> dropDown1;

    @FindBy(how = How.XPATH, using = "//td[@class='operators']/select/option")
    private List<WebElement> dropDown2;

    @FindBy(how = How.XPATH, using = "//input[@role='textbox'][@class='input-elm']")
    private WebElement fieldInput;

    @FindBy(how = How.XPATH, using = "//span[text()='Найти']")
    private WebElement buttonFind;

    public void checkElementPage(String elemText) throws  InterruptedException{
        checkElementIgnoreCase(searchModalPage, elemText);
    }

    public void chooseOption1(String elemText){
        clickOnListOfElementsStartWith(dropDown1, elemText);
    }

    public void chooseOption2(String elemText){
        clickOnListOfElementsStartWith(dropDown2, elemText);
    }

    public void inputValue(String elemText){
        inputValue(fieldInput,elemText);
    }

    public void clickButton(String elemText){
        clickButton(buttonFind, elemText);
    }

}
