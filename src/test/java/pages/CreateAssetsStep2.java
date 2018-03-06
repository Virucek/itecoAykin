package pages;

import cucumber.api.java.uk.Нехай;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

public class CreateAssetsStep2 extends Base {

    public CreateAssetsStep2(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return "fullAssetCard";
    }

    @FindBy(how = How.XPATH, using = "(//ol[@class='breadcrumb']//li)[2]")
    private WebElement formTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='scrolable-tabs-container']//ul//a")
    private List<WebElement> navigationElements;

    @FindBy(how = How.XPATH, using = "//input[@name='accountNum']")
    private WebElement numField;

    @FindBy(how = How.XPATH, using = "//input[@name='balanceInitial']")
    private WebElement startBalance;

    @FindBy(how = How.XPATH, using = "//input[@name='balanceRur']")
    private WebElement nowBalance;

    @FindBy(how = How.XPATH, using = "//input[@name='balanceInitialCur']")
    private WebElement startValuteBalance;

    @FindBy(how = How.XPATH, using = "//input[@name='balanceCur']")
    private WebElement nowValuteBalance;

    @FindBy(how = How.XPATH, using = "//input[@name='startDate']")
    private WebElement startDate;

    @FindBy(how = How.XPATH, using = "//input[@name='endDate']")
    private WebElement endDate;

    @FindBy(how = How.XPATH, using = "//select[@name='currency']")
    private WebElement currency;

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private WebElement assetName;

    @FindBy(how = How.XPATH, using = "//div[@class='row form-group']//button")
    private List<WebElement> buttons;

    public void checkElementPage(String elemText) throws InterruptedException{
        checkElement(formTitle, elemText);
    }

    public List<String> checkNavigationElements(){
        return navigationElements.stream().limit(13).
                map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickOnNavigationElement(String elemText){
        clickOnListOfElements(navigationElements, elemText);
    }

    public void inputValue(String field, String value){
        if(field.equals("Номер счёта")){
            inputValue(numField, value);
        }else if(field.equals("Начальная балансовая стоимость")){
            inputValue(startBalance, value);
        }else if(field.equals("В валюте счёта")){
            inputValue(startValuteBalance, value);
        }else if(field.equals("Наименование актива")){
            inputValue(assetName, value);
        }else if(field.equals("Дата начала действия актива")){
            inputValue(startDate, value);
        }else if(field.equals("Дата окончания действия актива")){
            inputValue(endDate, value);
        }
    }

  /*  public void checkRubBalance(String value) throws InterruptedException{
        checkElement(nowBalance, value);
    }

    public void checkValuteBalance(String value) throws InterruptedException{
        checkElement(nowValuteBalance, value);
    }*/

    public void checkCurrency(String value) throws InterruptedException{
        checkElement(currency, value);
    }

    public void clickButton(String value){
        clickOnListOfElementsBreak(buttons, value);
    }

    public void pushTabKey(String field) throws InterruptedException{
        if(field.equals("Дата начала действия актива")){
            clickKeyTab(startDate);
        }else if(field.equals("Дата окончания действия актива")){
            clickKeyTab(endDate);
        }
    }

    public void getValue(String field1, String field2){
        if(field1.equals("Текущая балансовая стоимость")&& field2.equals("Начальная балансовая стоимость")) {
            getValue(nowBalance, startBalance);
        }
        if(field1.equals("В валюте счёта")&& field2.equals("В валюте счёта")) {
            getValue(nowValuteBalance, startValuteBalance);
        }
    }
}
