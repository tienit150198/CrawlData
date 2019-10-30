
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileService {
	public Set<String> readOldUrl(File file) {
		Set<String> oldUrl = new HashSet<>();

		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bfr = new BufferedReader(isr);
			String readLine = null;

			while ((readLine = bfr.readLine()) != null) {
				oldUrl.add(readLine.trim());
			}

			bfr.close();
			isr.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return oldUrl;
	}

	public Map<String, String> readConfig(File file, String format) {
		try {
			Map<String, String> isMap = new HashMap<>();
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bfr = new BufferedReader(isr);

			String readLine = null;
			while ((readLine = bfr.readLine()) != null) {
				if (readLine.startsWith("--") && readLine.endsWith("--"))
					continue;

				String split[] = readLine.split(format);

				isMap.put(split[0].trim(), split[1].trim());
			}

			bfr.close();
			isr.close();
			fis.close();
			return isMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, String> readTail(File file, String format) {

		try {
			Map<String, String> isMap = new HashMap<>();
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bfr = new BufferedReader(isr);

			String readLine = null;
			while ((readLine = bfr.readLine()) != null) {
				if (readLine.startsWith("--") && readLine.endsWith("--"))
					continue;
				String split[] = readLine.split(format);

				isMap.put(split[0].trim(), split[1].trim());
			}

			bfr.close();
			isr.close();
			fis.close();
			return isMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Map<String, Map<List<String>, String>>> readCondition(File file, String format1, String format2,
			String format3) {

		try {
			Map<String, Map<String, Map<List<String>, String>>> isMap = new HashMap<>();
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bfr = new BufferedReader(isr);

			String readLine = null;
			Map<String, String> listMaps = new HashMap<>();
			while ((readLine = bfr.readLine()) != null) {
				if (readLine.startsWith("--") && readLine.endsWith("--"))
					continue;
				String splits[] = readLine.split(format1);
				String isKey = splits[0].trim();
				String isValue = splits[1].trim();
				listMaps.put(isKey, isValue);
			}

			listMaps.forEach((keyMap, valueMap) -> {
				List<String> isList = new ArrayList<>();
				String splits[] = valueMap.split(format2);
				for (String split : splits) {
					isList.add(split.trim());
				}

				Map<String, Map<List<String>, String>> listMapTwo = new HashMap<>();

				isList.forEach((str) -> {

					String splits1[] = str.split(format3);
					List<String> values = new ArrayList<>();

					Map<List<String>, String> listMapOne = new HashMap<>();

					String key = splits1[0].trim();
					String regex = splits1[1].trim();

					for (int i = 2; i < splits1.length; i++) {
						values.add(splits1[i].trim());
					}
					listMapOne.put(values, regex);
					listMapTwo.put(key, listMapOne);
				});
				isMap.put(keyMap, listMapTwo);
			});

			bfr.close();
			isr.close();
			fis.close();
			return isMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
