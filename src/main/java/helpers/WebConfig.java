package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${environment}.properties"
})

public interface WebConfig extends Config {
    @Key("remote.url")
    String remoteUrl();

    @Key("video")
    String remoteVideo();
}
