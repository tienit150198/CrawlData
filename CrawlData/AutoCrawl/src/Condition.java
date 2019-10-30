import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Condition {
	private static Map<String,Map<String, Map<List<String>, String>>> mapQuerySelector = new HashMap<>();
	
	static {
		init();
	}
	
	public static Map<String,Map<String, Map<List<String>, String>>> getMapQuerySelector() {
		return mapQuerySelector;
	}

	private static void init() {
		mapQuerySelector = new FileService().readCondition(new File("files/condition.dat"),"=::=>","-->", "=-==-=>");
	}
}
