package Data;

/**
 * Created by Sniper on 2018/4/16.
 */
public class Config {
    private static final Config config = new Config();
    private String id;
    private String version;
    private String firstUse;
    private String update;
    private Config(){

    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getFirstUse() {
        return firstUse;
    }

    public void setFirstUse(String firstUse) {
        this.firstUse = firstUse;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static Config getConfig() {
        return config;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
