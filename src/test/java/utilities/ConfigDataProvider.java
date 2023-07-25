package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;

	public ConfigDataProvider() throws IOException {
		File src = new File("./config/config.properties");

		FileInputStream fis = new FileInputStream(src);

		pro = new Properties();

		pro.load(fis);
	}

	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}

	public String getBrowser() {
		return pro.getProperty("browser");
	}

	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}

}
