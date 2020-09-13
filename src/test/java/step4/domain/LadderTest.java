package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
	private static final String[] names = {"DAMI", "mong", "corgi", "abc", "heee"};
	private static Ladder ladder;

	@BeforeEach
	void set() {
		ladder = new Ladder(new Users(names));
	}

	@DisplayName(value = "입력한 높이만큼 사다리 라인 생성 확인")
	@Test
	void makeLadderTest() {
		ladder = ladder.makeLadder(5);
		assertThat(ladder).isInstanceOf(Ladder.class);
		assertThat(ladder).hasNoNullFieldsOrProperties();
		assertThat(ladder.getCreatedLadder()).hasSize(5);
	}

	@DisplayName(value = "입력한 사용자가 참여자 목록에 포함되어 있는지 확인")
	@Test
	void allUserTest() {
		assertThat(ladder.getAllUserName()).hasSameElementsAs(Arrays.asList(names));
	}

	@DisplayName(value = "입력한 위치의 참여자명 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:DAMI", "1:mong", "2:corgi", "3:abc", "4:heee"}, delimiter = ':')
	void userIndexTest(int index, String name) {
		assertThat(ladder.getUserName(index)).isEqualTo(name);
	}

	@DisplayName(value = "입력한 이름이 게임 참여자인지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"DAMI:true", "mong:true", "coco:false", "ccc:false"}, delimiter = ':')
	void containUserTest(String name, boolean expected) {
		assertThat(ladder.containUser(name)).isEqualTo(expected);
	}

	@DisplayName(value = "입력한 이름의 위치 테스트")
	@ParameterizedTest
	@CsvSource(value = {"DAMI:0", "mong:1", "corgi:2", "abc:3", "heee:4"}, delimiter = ':')
	void userPositionTest(String name, int expected) {
		assertThat(ladder.getUserPositionOf(name)).isEqualTo(expected);
	}
}
