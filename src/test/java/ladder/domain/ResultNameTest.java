package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultNameTest {

	@DisplayName("유효한 값으로 결과이름 입력 시, 객체를 반환한다.")
	@ValueSource(strings = {"pobi", "honux", "crong", "jk", "all"})
	@ParameterizedTest
	void test1(String input) {
		Names names = new Names("pobi,honux,crong,jk");
		ResultName resultName = new ResultName(names, input);
		assertThat(resultName).isEqualTo(new ResultName(names, input));
	}

	@DisplayName("존재하지 않는 참가자 입력 시, 예외를 반환한다.")
	@ValueSource(strings = {"conan", "linux", "croll", "jd"})
	@ParameterizedTest
	void test2(String input) {
		Names names = new Names("pobi,honux,crong,jk");
		assertThatIllegalArgumentException().isThrownBy(() -> new ResultName(names, input));
	}
}
