package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Base;
import pages.LoginForm;
import pages.ModalWindowChooseOrganization;

public class InitialSteps {
    static WebDriver driver;

    /*public static LoginForm loginForm;
    public static ModalWindowChooseOrganization modalWindowChooseOrganization;*/

    public static Base page;
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
     //       options.addArguments("--no-startup-window");
     //       options.addArguments("--headless");
            options.addArguments("dom.webnotifications.enabled");
            driver = new ChromeDriver(options);
           /* loginForm = new LoginForm(driver);
            modalWindowChooseOrganization = new ModalWindowChooseOrganization(driver);*/
            page = new Base(driver);
            }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowserGoToPage() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua");
    }

    @Тогда("^браузер закрыт$")
    public void closeBrowser() throws Throwable {
        driver.quit();
        driver = null;
    }
}
