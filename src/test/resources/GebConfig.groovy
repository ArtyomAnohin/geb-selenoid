import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import com.aoe.gebspockreports.GebReportingListener

reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'

waiting {
    timeout = 2
}

environments {
    chrome {
        driver = { new ChromeDriver() }
    }
    chromeHeadless {
        driver = {
            ChromeOptions o = new ChromeOptions()
            o.addArguments('headless')
            new ChromeDriver(o)
        }
    }

    firefox {
        atCheckWaiting = 1

        driver = { new FirefoxDriver() }
    }

    remoteChrome {
        driver = {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("77.0");
            capabilities.setCapability("enableVideo",true)
            capabilities.setCapability("enableLog",true)
            capabilities.setCapability("enableVNC",true)
            new RemoteWebDriver(
                    URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                    capabilities
            )
        }
    }

    remoteFirefox {
        driver = {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("latest");

            new RemoteWebDriver(
                    URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                    capabilities
            );
        }
    }
}

baseUrl = "http://gebish.org"