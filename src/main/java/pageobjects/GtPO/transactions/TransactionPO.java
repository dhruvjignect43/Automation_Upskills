package pageobjects.GtPO.transactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

import java.util.List;
import java.util.Random;

public class TransactionPO extends BasePO {
    public TransactionPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "shortcutDate")
    private WebElement transactionDropDown;

    @FindBy(css = "td[label='transactions-table-amount']")
    private WebElement transactionText;



    /**
     * Transaction RandomDropdown
     *
     * @throws InterruptedException Exception
     */
    public void selectTheValueFromTheDropDown() throws InterruptedException {
        selenium.click(transactionDropDown);
        List<WebElement> dropdownElements = driver.findElements(By.cssSelector("select[label*='shortcutDate']"));
        Random random = new Random();
        int randomIndex = random.nextInt(dropdownElements.size());
        WebElement dropdownElement = dropdownElements.get(randomIndex);
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        int randomOptionIndex = random.nextInt(options.size());
        String optionText = options.get(randomOptionIndex).getText();
        dropdown.selectByVisibleText(optionText);
    }

    /**
     * @return getText
     */
    public String getTransactionText() {

        List<WebElement> elements = driver.findElements(By.cssSelector("td[label='transactions-table-amount']"));

        if (elements != null && !elements.isEmpty()) {
            for (WebElement element : elements) {
                String text = element.getText().replaceAll("[^\\d.]","");
                if (text != null && !text.isEmpty()) {
                    return text;
                }
            }
        } else {
            System.out.println("No elements found");
        }
        return null;
    }
}
