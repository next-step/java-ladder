package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LocationTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    @DisplayName("Location 의 값은 0을 포함한 양수이다.")
    void create(int value) {
        Location location = Location.from(value);

        assertThat(location).isNotNull();
    }

    @Test
    @DisplayName("Location 음수 생성 시 예외 발생")
    void exceptByCreate() {
        assertThatIllegalArgumentException().isThrownBy(() -> Location.from(-1))
                .withMessage("위치 값은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("Location 은 좌 우 1단위로 움직인다")
    void move() {
        Location standardLocation = Location.from(10);

        assertThat(standardLocation.toLeft()).isEqualTo(Location.from(9));
        assertThat(standardLocation.toRight()).isEqualTo(Location.from(11));
    }

}
