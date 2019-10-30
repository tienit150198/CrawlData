import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Config {
private static Map<String, String> config = new HashMap<>();
	
	static {
		init();
	}
	
	public static Map<String, String> getConfig() {
		return config;
	}

	private static void init() {
		config = new FileService().readConfig(new File("files/config.dat"),"-->");
	}
}
