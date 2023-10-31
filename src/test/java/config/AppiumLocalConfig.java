package config;

import org.aeonbits.owner.Config;

    @Config.Sources({
            "classpath:local.properties"
    })
    public interface AppiumLocalConfig extends Config {
        @Key("platformVersion")
        String getPlatformVersion();

        @Key("platformName")
        String getPlatformName();

        @Key("deviceName")
        String getDeviceName();
    }
