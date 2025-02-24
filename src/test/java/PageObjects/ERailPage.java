package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class ERailPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "txtStationFrom")
    WebElement fromField;

    @FindBy(xpath = "//div[starts-with(@id,\"Autocomplete\") and contains(@class,\"autocomplete\")] /div")
    List<WebElement> dropdownOptions;

    @FindBy(css = "input[title='Select Departure date for availability']")
    WebElement dateField;

    public ERailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void selectFromStation(String station) {
        fromField.clear();
        fromField.sendKeys(station);
    }

    public String selectFourthStation() {
        if (dropdownOptions.size() >= 4) {
            String stationName = dropdownOptions.get(3).getText();
            dropdownOptions.get(3).click();
            return stationName;
        }
        return "";
    }

    public void selectDate(int daysFromToday) {
    // Calculate the target date
    LocalDate targetDate = LocalDate.now().plusDays(daysFromToday);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy E"); // Example: "09-Mar-25 Sun"
    String formattedDate = targetDate.format(formatter);

    // Use JavaScript to set the date value
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].setAttribute('value', arguments[1])", dateField, formattedDate);

    // Explicit wait to ensure UI reflects the change
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    wait.until(ExpectedConditions.attributeToBe(dateField, "value", formattedDate));
}

    public List<String> getDropdownStations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownOptions));

        return dropdownOptions.stream()
                .map(WebElement::getText) // Get the text of each dropdown item
                .map(text -> text.split("\n")[0]) // Extract only the station name (ignore the code)
                .collect(Collectors.toList());
    }


}
