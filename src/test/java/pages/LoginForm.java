package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LoginForm extends Base{

    public String getTitle() {
        return "login";
    }

    public LoginForm(WebDriver driver){
        super(driver);
    };

    @FindBy(how = How.XPATH, using = "//h3[text()='Вход в систему']")
    public WebElement formEnterTitle;

    @FindBy(how = How.XPATH, using = "//input[@class='form-control']")
    public List<WebElement> fieldsLoginPassword;

    @FindBy(how = How.XPATH, using = "//form[@class='form-signin']/button")
    public WebElement enterButton;

    @FindBy(how = How.XPATH, using = "//form/div[@role='alert']")
    public WebElement message;

    public void checkElement(String elemTitle) throws InterruptedException {
        checkElement(formEnterTitle, elemTitle);
    }

    public void checkMessageElement(String elemText)throws InterruptedException{
        checkElement(message, elemText);
    }

    public void inputEnterDataForm(String elemText, String value) throws InterruptedException{
        inputEnterData(fieldsLoginPassword, elemText, value);
    }

    /*public void inputEnterDataForm(List<WebElement> elements, String elemText, String value){
        for (WebElement element : elements){
            if(element.getAttribute("placeholder").equals(elemText)){
                element.sendKeys(value);
            }
        }
    }
*/
    public void clickButton(String elemText){
        clickButton(enterButton, elemText);
    }
}
