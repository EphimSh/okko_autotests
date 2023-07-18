package guru.qa.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadType;

@Config.LoadPolicy(LoadType.MERGE)
@Config.Sources({"classpath:${env}.properties"})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("114.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
    @Key("baseUrl")
    @DefaultValue("https://okko.tv")
    String getBaseUrl();
    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("pageLoadStrategy")
    @DefaultValue("eager")
    String getPageLoadStrategy();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}
