package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.И;
import org.junit.Assert;
import pages.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static stepDefinition.InitialSteps.*;

public class StepImplementation {

    @Когда("^открывается страница с (формой|финансовой организацией) \"([^\"]*)\".*$")
    public void openPages(String actions, String element) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).checkOrgName(element);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())) {
            page.GetInstance(LoginForm.class).checkElement(element);
        }
    }

    @Когда("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillInputFields(String field, String value) throws Throwable {
        if(driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())){
            page.GetInstance(LoginForm.class).inputEnterDataForm(field, value);
        } else if(driver.getCurrentUrl().contains(page.GetInstance(CreateAssetsStep2.class).getTitle())){
            page.GetInstance(CreateAssetsStep2.class).inputValue(field, value);
        }
    }

    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())) {
            page.GetInstance(LoginForm.class).clickButton(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowChooseOrganization.class).getTitle())) {
            page.GetInstance(ModalWindowChooseOrganization.class).clickButton(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowSearchTable.class).getTitle())) {
            page.GetInstance(ModalWindowSearchTable.class).clickButton(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(AssetsList.class).getTitle())) {
            page.GetInstance(AssetsList.class).clickTopButton(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(CreateAssetsStep1.class).getTitle())) {
            page.GetInstance(CreateAssetsStep1.class).clickNextButton(value);
        } else if(driver.getCurrentUrl().contains(page.GetInstance(CreateAssetsStep2.class).getTitle())){
            page.GetInstance(CreateAssetsStep2.class).clickButton(value);
        }
    }

    @Когда("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню")
    public void clickExitButton(String value) throws Throwable {
        page.GetInstance(Header.class).clickExitButton(value);
    }

    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО из списка$")
    public void chooseOrg(String element) throws Throwable {
        page.GetInstance(ModalWindowChooseOrganization.class).chooseOrgName(element);
    }

    @Тогда("^открывается модальное окно \"([^\"]*)\"$")
    public void openModalWindow(String modal) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowChooseOrganization.class).getTitle())) {
            page.GetInstance(ModalWindowChooseOrganization.class).checkElement(modal);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowSearchTable.class).getTitle())) {
            page.GetInstance(ModalWindowSearchTable.class).checkElementPage(modal);
        }
    }

    @Тогда("^закрывается модальное окно \"([^\"]*)\"$")
    public void closedModalWindow(String modal) throws Throwable {
        page.GetInstance(ModalWindowChooseOrganization.class).checkClosedElement(modal);
    }

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void openedPageWithLogo(String elemText) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).checkLogoName(elemText);
        }
    }

    @Когда("^пользователь заполняет поле \"([^\"]*)\" и поле \"([^\"]*)\" значениями$")
    public void inputEnterDataForm(String a, String b, DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        page.GetInstance(LoginForm.class).inputEnterDataForm(a, list.get(0));
        page.GetInstance(LoginForm.class).inputEnterDataForm(b, list.get(1));
    }

    @Тогда("^открывается страница с сообщением \"([^\"]*)\"$")
    public void openedPageWithMessage(String elemText) throws Throwable {
        page.GetInstance(LoginForm.class).checkMessageElement(elemText);
    }

    @Когда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void clickDropdownMenuButton(String value) throws Throwable {
        page.GetInstance(Header.class).clickDropDownButton(value);
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void clickMenuButton(String value) throws Throwable {
        page.GetInstance(Header.class).chooseOption(value);
    }

    @Тогда("^открывается экранная форма \"([^\"]*)\"$")
    public void openFormPage(String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(TableReferenceBook.class).getTitle())) {
            page.GetInstance(TableReferenceBook.class).checkElementPage(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(AccountPlanCO.class).getTitle())) {
            page.GetInstance(AccountPlanCO.class).checkElementPage(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(AssetsList.class).getTitle())) {
            page.GetInstance(AssetsList.class).checkElementPage(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(CreateAssetsStep1.class).getTitle())) {
            page.GetInstance(CreateAssetsStep1.class).checkElementPage(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(CreateAssetsStep2.class).getTitle())) {
            page.GetInstance(CreateAssetsStep2.class).checkElementPage(value);
        }
    }

    @Тогда("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"$")
    public void clickReferenceInTable(String value) throws Throwable {
        page.GetInstance(TableReferenceBook.class).clickReferenceInColumn(value);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void clickButtonInTableHeader(String value) throws Throwable {
        if(driver.getCurrentUrl().contains(page.GetInstance(AccountPlanCO.class).getTitle())){
            page.GetInstance(AccountPlanCO.class).clickOnTableButton(value);
        } else if(driver.getCurrentUrl().contains(page.GetInstance(AssetsList.class).getTitle())){
            page.GetInstance(AssetsList.class).clickOnTableButton(value);
        }
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"(Значимый актив|ID Плана Счетов)\"$")
    public void chooseOption1(String value) throws Throwable {
        page.GetInstance(ModalWindowSearchTable.class).chooseOption1(value);
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"(равно|содержит)\"$")
    public void chooseOption2(String value) throws Throwable {
        page.GetInstance(ModalWindowSearchTable.class).chooseOption2(value);
    }

    @Когда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void inputFields(String value) throws Throwable {
        page.GetInstance(ModalWindowSearchTable.class).inputValue(value);
    }

    @Тогда("^отображается \"Номер счёта 2-го порядка\" содержащий \"([^\"]*)\"$")
    public void checkPresenceAccount(String value) throws Throwable {
        page.GetInstance(AccountPlanCO.class).checkAccount(value);
    }

    @Тогда("^на экранной форме присутствует поле \"([^\"]*)\"$")
    public void fieldOnForm(String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(CreateAssetsStep1.class).getTitle())) {
            page.GetInstance(CreateAssetsStep1.class).checkField(value);
        }
    }

    @Тогда("^поле \"Наименование ФО\" недоступно для редактирования$")
    public void fieldIsDisabled() throws Throwable {
        page.GetInstance(CreateAssetsStep1.class).checkFieldIsDisabled();
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Тип актива функциональный\"$")
    public void chooseOptionAssetType(String value) throws Throwable {
        page.GetInstance(CreateAssetsStep1.class).chooseOptionTypeAsset(value);
    }

    /*
        @Тогда("^на экранной форме \"Список активов (второй этап)\" присутствуют закладки$")
        public void checkNavigationElements(DataTable dataTable) throws Throwable {
            List<String> navigationElements = dataTable.asList(String.class);
            Assert.assertEquals(navigationElements, page.GetInstance(CreateAssetsStep2.class).checkNavigationElements());
        }
    */
    @Когда("^присутствуют закладки на экранной форме \"([^\"]*)\"$")
    public void checkNavigationElements(String el, DataTable dataTable) throws Throwable {
        List<String> navigationElements = dataTable.asList(String.class);
        Assert.assertEquals(navigationElements, page.GetInstance(CreateAssetsStep2.class).checkNavigationElements());
    }

 /*   @Тогда("^отображается \"Текущая балансовая стоимость\" содержащий \"([^\"]*)\"$")
    public void checkRubBalance(String value) throws Throwable {
        page.GetInstance(CreateAssetsStep2.class).checkRubBalance(value);
    }

    @Тогда("^отображается \"В валюте счёта\" содержащий \"([^\"]*)\"$")
    public void checkValuteBalance(String value) throws Throwable {
        page.GetInstance(CreateAssetsStep2.class).checkValuteBalance(value);
    }*/

    @Тогда("^поле \"Валюта счёта\" содержит \"([^\"]*)\"$")
    public void checkCurrency(String value) throws Throwable {
        page.GetInstance(CreateAssetsStep2.class).checkCurrency(value);
    }

    @Когда("^пользователь переходит на вкладку \"([^\"]*)\"$")
    public void goToNavigationElement(String value) throws Throwable {
        page.GetInstance(CreateAssetsStep2.class).clickOnNavigationElement(value);
    }

    @Когда("^пользователь нажимает на поле \"([^\"]*)\"$")
    public void clickOnField(String value) throws Throwable {
        page.GetInstance(CreateAssetsStep2.class).clickButton(value);
    }

    @Когда("^пользователь нажимает клавишу Tab на поле \"([^\"]*)\"$")
    public void pushTabKey(String field) throws Throwable{
        page.GetInstance(CreateAssetsStep2.class).pushTabKey(field);
    }

    @Когда("^содержимое полей \"([^\"]*)\" и \"([^\"]*)\" одинаково$")
    public void getBalance(String field1, String field2) throws Throwable{
        page.GetInstance(CreateAssetsStep2.class).getValue(field1, field2);
    }

}
