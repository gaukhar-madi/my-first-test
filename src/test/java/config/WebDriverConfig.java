package config;

import org.aeonbits.owner.Config;

/**
 * Конфигурация запуска браузера.
 * Значения берутся сначала из системных свойств (передаются из командной строки: -Dbrowser=firefox ...),
 * затем из classpath-файла config.properties (значения по умолчанию).
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("remoteUrl")
    @DefaultValue("")
    String remoteUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();
}
