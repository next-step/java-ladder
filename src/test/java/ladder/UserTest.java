package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class UserTest {

	@DisplayName("사람이름은 5글자 이하이어야 한다.")
	@Test
	void userNameWithOverFive() {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					User.createUser("Timberland");
				}).withMessageMatching("이름은 5자 이하여야 합니다.");
	}

	@DisplayName("사람이름은 null이나 빈값일수 없다.")
	@ParameterizedTest
	@NullAndEmptySource
	void userNameWithNullOrEmpty(String name) {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					User.createUser(name);
				}).withMessageMatching("이름은 null이나 빈 문자열이 될 수 없습니다.");
	}
}
