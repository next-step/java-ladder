package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class HeightTest {
	@DisplayName("높이는 1이상이어야 한다.")
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void heightGreaterThanOne(int height) {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Height.createHeight(height);
				}).withMessageMatching("높이는 1 이상이어야 합니다.");
	}
}
