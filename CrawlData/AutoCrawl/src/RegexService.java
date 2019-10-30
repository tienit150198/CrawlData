

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexService {
	List<String> isRegex(String text, String regex, List<String> textIgnore) {
		List<String> res = new ArrayList<>();

		//
		text = text.replaceAll("&nbsp;", " ");
		text = text.replaceAll("&amp;", "&");
		text = text.replaceAll("&quot;", "\"");
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			String text1 = matcher.group(1);
			if(!text1.trim().equals("") && !textIgnore.contains(text1.trim())) {
				res.add(text1.trim());
			}
		}
		if(res.isEmpty())
			res.add("");
		
		return res;
	}
}
