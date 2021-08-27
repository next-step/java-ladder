package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @ParameterizedTest
    @DisplayName("Location 생성 성공 테스트")
    @ValueSource(ints = {2, 3, 4, 5})
    void 위치_생성_성공_테스트(int number) {
        Location location = new Location(number);
        assertThat(location).isEqualTo(new Location(number));
    }
}
