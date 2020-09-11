package step2.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
	private static Ladder ladder;

	@BeforeAll
	static void makeLadder() {
		String[] names = {"DAMI", "mong", "corgi", "abc", "heee"};

		ladder = new Ladder(new Users(names));
		ladder = ladder.makeLadder(7);
	}

	@DisplayName(value = "입력한 사용자가 참여자 목록에 포함되어 있는지 확인")
	@ParameterizedTest
	@ValueSource(strings = {"DAMI", "mong", "corgi", "abc", "heee"})
	void userTest(String expected) {
		assertThat(ladder.getUsersName()).contains(expected);
	}
}
