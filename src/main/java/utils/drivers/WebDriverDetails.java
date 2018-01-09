package utils.drivers;

import org.openqa.selenium.WebDriver;

public interface WebDriverDetails {
    boolean setAssumeUntrustedCertificateIssuer = true;
    boolean setAcceptUntrustedCertificates = true;
    boolean enableJavascript = true;
    //     WebDriver driver;
//     BrowserType browser = BrowserType.FireFox;
//    private DriverMode mode = DriverMode.LOCAL;
    String hubUrl = "";
    String ffProfilePath = "";
    String operaProfilePath = "";
    String ffBinPath = "";
//    private String ieDriverPath;
//    private String chromeDriverPath;
//    private String chromeBinPath;
}
