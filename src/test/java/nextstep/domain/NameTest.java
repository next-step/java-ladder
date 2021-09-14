package nextstep.domain;

import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

	@DisplayName("이름 길이의 제한을 확인하는 테스트")
	@Test
	void test_name_length() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Name name = new Name("abcdefg");
		});
	}
}
