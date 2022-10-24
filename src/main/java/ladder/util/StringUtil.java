package ladder.util;

/**
 * Created by seungwoo.song on 2022-10-24
 */
public class StringUtil {
	private StringUtil() {
	}

	public static boolean isNotBlank(String result) {
		return result != null && !result.isEmpty();
	}
}
