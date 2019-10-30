import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TailHTML {
private static Map<String, String> infoWeb = new HashMap<>();
	
	static {
		init();
	}
	
	public static Map<String, String> getInfoWebsite() {
		return infoWeb;
	}

	private static void init() {
		infoWeb = new FileService().readTail(new File("files/tailWeb.dat"),"-->");
	}
}
