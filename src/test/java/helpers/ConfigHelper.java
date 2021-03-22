package helpers;

import org.aeonbits.owner.ConfigFactory;


public class ConfigHelper {

    public static String getURL() {
        return getConfig().remoteUrl();
    }

    public static String getVideo() {
        return getConfig().remoteVideo();
    }

    private static WebConfig getConfig() {
        if (System.getProperty("environment") == null) System.setProperty("environment", "test");   // test, prod
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}