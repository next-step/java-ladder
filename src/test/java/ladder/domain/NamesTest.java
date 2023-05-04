package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

	@DisplayName("참여할 사람 이름 예외 케이스 - 5자 초과")
	@Test
	void test1() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Names("pobi, honux, crong, pobipo"));
	}

	@DisplayName("참여할 사람 이름 예외 케이스 - 공백")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Names("pobi,   , crong"));
	}

	@DisplayName("참여할 사람 등록")
	@Test
	void test3() {
		Names names = new Names("pobi,honux,crong,jk");
		assertThat(names).isEqualTo(new Names("pobi,honux,crong,jk"));
	}
}
