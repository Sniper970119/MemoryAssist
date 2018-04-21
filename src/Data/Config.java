package Data;

/**
 * Created by Sniper on 2018/4/16.
 */
public class Config {
    private static final Config config = new Config();
    private String id;
    private Config(){

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
