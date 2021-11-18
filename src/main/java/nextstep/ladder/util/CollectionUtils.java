package nextstep.ladder.util;

import java.util.Collection;

import nextstep.ladder.exception.UtilCreationException;

public final class CollectionUtils {
	private CollectionUtils() {
		throw new UtilCreationException();
	}

	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}
}
