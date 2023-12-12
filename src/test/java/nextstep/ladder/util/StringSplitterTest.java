package nextstep.ladder.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.util.StringSplitter;

public class StringSplitterTest {
	@DisplayName("콤마를 기준으로 문자열을 나눕니다.")
	@Test
	void validate_split_by_comma() {
		Assertions.assertThat(
			StringSplitter.splitByComma("김,광,현")
		).isEqualTo(
			List.of(
				new User("김"),
				new User("광"),
				new User("현")
			)
		);
	}
}
