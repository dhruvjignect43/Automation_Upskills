package utilities;

public class Constants {
    public static final String PROPERTY_FILE = "src/main/resources/constants.properties";

    //Setting up the URLs
    public static final String URL = JavaHelpers.getPropertyValue(PROPERTY_FILE, "url");
    public static final String Env = JavaHelpers.setSystemVariable(PROPERTY_FILE, "Env");

    //Selenium constants
    public static final int WEBDRIVER_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE, "WebDriverWaitDuration"));
    public static final int MINIMUM_WEBDRIVER_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE, "MinimumWebDriverWaitDuration"));
    public static final int PAGEFACTORY_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE, "PageFactoryWaitDuration"));
    public static final String SCREENSHOT_LOCATION = JavaHelpers.getPropertyValue(PROPERTY_FILE, "ScreenshotLocation");

    // Email constants
    public static final String MAILINATORNAME = "mailinator";
    public static final String MAILINATORURL =
            "https://www.mailinator.com/v4/public/inboxes.jsp?to=";

    //Validation Message
    public static final String getUserName = "u66813399";
    public static final String getLoginValidationText = "Die Kombination aus Spielername und Passwort ist nicht korrekt.";
    public static final String getHomeLoginText = "Login";
    public static final String getAlertPopUpText = "Ihre Einladung wurde erfolgreich versandt!";
    public static final String getAlertPopUpTextOneMin = "Zu viele Aufrufe in den letzten 1 Minuten. Bitte 1 Minuten warten.";
    public static final String getDepositHeadingText = "Einzahlen";
    public static final String getTextValidationPreviousGame = "Es sind keine Resultate verfügbar. Bitte versuchen Sie es später noch einmal oder wählen Sie einen anderen Zeitraum aus.";
    public static final String getRegistrationTextPopUp = "Spielerkontoverifizierung";
    public static final String getBonusHistoryText = "In der Tabelle unten findest du eine Übersicht deiner Bonushistorie der vergangenen drei Monate.";
    public static final String getDepositText = "Geld einzahlen";
    public static final String getCashBackText = "MEINE BONI";
    public static final String getOasisGetText = "OASIS-Selbstsperre";
    public static final String getOasisErrorMessageText = "Das eingegebene Passwort ist falsch.";
    public static final String getSuccessMessageOfLimits = "Dieses Limit wird in 3 Tag(en) freigegeben.";
    public static final String getPlayGameText = "24 STUNDEN SPERRE";

    private Constants() {
        throw new IllegalStateException("Constants class");
    }
}
