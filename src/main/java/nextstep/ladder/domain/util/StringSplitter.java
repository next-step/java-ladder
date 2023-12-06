package nextstep.ladder.domain.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.User;

public class StringSplitter {
	public static List<User> splitByComma(String str) {
		return Arrays.stream(str.split(","))
			.map(User::new)
			.collect(Collectors.toList());
	}
}
