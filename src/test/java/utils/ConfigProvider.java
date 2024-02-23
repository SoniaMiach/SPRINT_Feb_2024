package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface ConfigProvider {
    static Config readConf() {
        return ConfigFactory.load("application.conf");
    }

    String PHONE = readConf().getString("phone");
    String PASSWORD = readConf().getString("password");
    String CITY = readConf().getString("city");
}
