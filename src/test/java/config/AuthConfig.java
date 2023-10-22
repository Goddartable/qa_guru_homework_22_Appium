package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {
    @Key("user")
    String getUserLogin();

    @Key("key")
    String getUserPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}