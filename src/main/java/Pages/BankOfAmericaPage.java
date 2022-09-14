package Pages;

import org.openqa.selenium.By;

public class BankOfAmericaPage {
    public String url = "https://www.bankofamerica.com/credit-cards/#filter";
    public By apply = new By.ByXPath("//a[contains(@id,'home_4060812')]");

    public By loginsavetime = new By.ByCssSelector("#signInSaveTime");
    public By firstname = new By.ByCssSelector("#customerFirstName");
    public By lastname = new By.ByCssSelector("#customerLastName");
    public By gender = new By.ByCssSelector("#customerNameSuffix");
    public By address = new By.ByCssSelector("#customerResidentialAddressOne");
    public By city = new By.ByCssSelector("#customerAddressCity");
    public By state = new By.ByCssSelector("#customerAddressState");
    public By zipcode = new By.ByCssSelector("#customerAddressInput");
    public By phonenumber = new By.ByCssSelector("#customerPrimaryPhoneNumber");
    public By email = new By.ByCssSelector("#customerEmailAddress");
    public By mobile = new By.ByCssSelector("[for='phoneNumberMobile']");
    public By saveandcontinue = new By.ByCssSelector("#icaiContinueButton");
    public By Citizenyes = new By.ByCssSelector("#customerUsCitizenYes");
    public By duelcitizen = new By.ByCssSelector("#customerDualCitizenshipNo");

    public By duelcitizenxpath = new By.ByXPath("//*[@id=\"customerDualCitizenship\"]/div[3]/div[2]/label");
    public By socialsc = new By.ByCssSelector(" #customerSocialSecurityNumber");

    public By countryresidense = new By.ByCssSelector("#customerCountryOfResidence");
    public By DateofBirth= new By.ByCssSelector("#customerBirthDate");

    public By employmentstatus= new By.ByCssSelector("#employmentStatus");

    public By occupation = new By.ByCssSelector("#occupation");

    public By annualincome= new By.ByCssSelector("#annualSalary");

    public By sourceincome= new By.ByCssSelector("#incomeSource");

    public By motnthlypayment= new By.ByCssSelector("#monthlyHousingPayment");

    public By checkbox= new By.ByCssSelector("#termsAndConditionsCheckBox");

    public By review= new By.ByCssSelector("#sectionHeader > div > div > h2");






}
