import java.util.List;
import java.util.Map;

public class Main {
	private static final int CRAWL = 0;
	private static final int DAY = 1;
	private static final int WEEK = 2;
	private static final int MONTH = 3;

	static Map<String, Map<String, Map<List<String>, String>>> listMapPre = Condition.getMapQuerySelector();
	static int choose = 0;
	static AnalyzeData x = new AnalyzeData();

	public static void main(String[] args) {

		switch (choose) {
		case CRAWL:
			listMapPre.forEach((key, values) -> {
				new Thread(new CrawlData(key, values)).start();
			});
			break;
		case DAY:
			x.showAnalyze_inday();
			break;

		case WEEK:
			x.showAnalyze_inweek();
			break;

		case MONTH:
			x.showAnalyze_inmonth();
			break;
		}

	}
}
