import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnalyzeData {
	ResultSet rs;
	Map<String, List<String>> listTagHot;
	Map<String, Long> countTags;
	SqlService t;
	static int count;
	private static final int limit = 10;
	List<String> listHot;

	public AnalyzeData() {
		listTagHot = new HashMap<>();
		countTags = new HashMap<>();
		t = new SqlService();
		count = 0;
		listHot = new ArrayList<>();
	}

	public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Entry.comparingByValue());
		Collections.reverse(list);

		Map<K, V> result = new LinkedHashMap<>();
		for (Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	public void startAnalyze_inday() throws SQLException {
		countTags.clear();
		SqlService t = new SqlService();

		rs = t.getUrlAndTag_inday();

		while (rs.next()) {
			String textTags = rs.getString(2);
			textTags = textTags.substring(1, textTags.length() - 1);
			List<String> listTag = new ArrayList<>();
			String splits[] = textTags.split(",");

			for (String split : splits) {
				listTag.add(split.trim());
				if (countTags.containsKey(split.trim())) {
					countTags.put(split.trim(), countTags.get(split.trim()) + 1);
				} else {
					countTags.put(split.trim(), (long) 1);
				}
			}

			listTagHot.put(rs.getString(1).trim(), listTag);
		}

	}

	public void startAnalyze_inweek() throws SQLException {
		countTags.clear();
		SqlService t = new SqlService();

		rs = t.getUrlAndTag_inweek();

		while (rs.next()) {
			String textTags = rs.getString(2);
			textTags = textTags.substring(1, textTags.length() - 1);
			List<String> listTag = new ArrayList<>();
			String splits[] = textTags.split(",");

			for (String split : splits) {
				listTag.add(split.trim());
				if (countTags.containsKey(split.trim())) {
					countTags.put(split.trim(), countTags.get(split.trim()) + 1);
				} else {
					countTags.put(split.trim(), (long) 1);
				}
			}

			listTagHot.put(rs.getString(1).trim(), listTag);
		}

	}

	public void startAnalyze_inmonth() throws SQLException {
		countTags.clear();

		rs = t.getUrlAndTag_inmonth();

		while (rs.next()) {
			String textTags = rs.getString(2);
			textTags = textTags.substring(1, textTags.length() - 1);
			List<String> listTag = new ArrayList<>();
			String splits[] = textTags.split(",");

			for (String split : splits) {
				if (split == null || split.trim().equals(""))
					continue;
				listTag.add(split.trim());
				if (countTags.containsKey(split.trim())) {
					countTags.put(split.trim(), countTags.get(split.trim()) + 1);
				} else {
					countTags.put(split.trim(), (long) 1);
				}
			}

			listTagHot.put(rs.getString(1).trim(), listTag);
		}

	}

	public void showAnalyze_inday() {
		listHot.clear();
		try {
			this.startAnalyze_inday();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listHot = getListHot();
		
		listHot.forEach((tagHot)->{
			System.err.println(tagHot + " -> " + countTags.get(tagHot));
			listTagHot.forEach((key, values) -> {
				if(values.contains(tagHot)) {
					System.err.println(key);
				}
			});
		});
	}

	public void showAnalyze_inweek() {
		listHot.clear();
		try {
			this.startAnalyze_inweek();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		listHot = getListHot();
		
		listHot.forEach((tagHot)->{
			System.err.println(tagHot + " -> " + countTags.get(tagHot));
			listTagHot.forEach((key, values) -> {
				if(values.contains(tagHot)) {
					System.err.println(key);
				}
			});
		});
	}

	public void showAnalyze_inmonth() {
		listHot.clear();
		try {
			this.startAnalyze_inmonth();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listHot = getListHot();

		listHot.forEach((tagHot)->{
			System.err.println(tagHot + " -> " + countTags.get(tagHot));
			listTagHot.forEach((key, values) -> {
				if(values.contains(tagHot)) {
					System.err.println(key);
				}
			});
			System.err.println();
		});
		
	}
	
	public List<String> getListHot(){
		List<String> isList = new ArrayList<>();
		
		countTags = sortByValue(countTags);	// sort map by value
		
		// get list 
		countTags.forEach((key, value) -> {
			if (count <= limit && !key.equals("")) {
				count++;
				isList.add(key);
			}
		});
		return isList;
	}

}
