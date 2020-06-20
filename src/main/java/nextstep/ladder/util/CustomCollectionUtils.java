package nextstep.ladder.util;

import java.util.List;
import java.util.Objects;

public class CustomCollectionUtils {

	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isEmpty(List list) {
		return list.stream().allMatch(Objects::isNull);
	}
}
