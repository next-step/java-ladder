package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.LocationLimitExceedException;
import nextstep.ladder.domain.ladder.HorizontalLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HorizontalLocationTests {
    private int countOfPerson;
    private int locationValue;

    @BeforeEach
    public void setup() {
        countOfPerson = 5;
        locationValue = 1;
    }

    @DisplayName("사다리 게임 참여자 수와 초기화 위치값을 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new HorizontalLocation(locationValue, countOfPerson)).isNotNull();
        assertThat(new HorizontalLocation(locationValue, countOfPerson))
                .isEqualTo(new HorizontalLocation(locationValue, countOfPerson));
    }

    @DisplayName("0 ~ 사다리 게임 참여자 수를 벗어나는 값으로 객체 생성 불가능")
    @ParameterizedTest
    @ValueSource(ints = { -2, -1, 8 })
    void validationTest(int invalidLocationValue) {
        assertThatThrownBy(() -> new HorizontalLocation(invalidLocationValue, countOfPerson))
                .isInstanceOf(LocationLimitExceedException.class);
    }

    @DisplayName("유효 범위 내에서 증가 연산 가능")
    @Test
    void upTest() {
        HorizontalLocation horizontalLocation = new HorizontalLocation(locationValue, countOfPerson);
        assertThat(horizontalLocation.moveRight()).isEqualTo(new HorizontalLocation(2, countOfPerson));
    }

    @DisplayName("유효 범위를 벗어난 증가 연산 수행 시 예외 발생")
    @Test
    void upValidationTest() {
        HorizontalLocation horizontalLocation = new HorizontalLocation(countOfPerson, countOfPerson);
        assertThatThrownBy(horizontalLocation::moveRight).isInstanceOf(LocationLimitExceedException.class);
    }

    @DisplayName("유효 범위 내에서 감소 연산 가능")
    @Test
    void downTest() {
        HorizontalLocation horizontalLocation = new HorizontalLocation(locationValue, countOfPerson);
        assertThat(horizontalLocation.moveLeft()).isEqualTo(new HorizontalLocation(0, countOfPerson));
    }

    @DisplayName("유효 범위를 벗어난 감소 연산 수행 시 예외 발생")
    @Test
    void downValidationTest() {
        HorizontalLocation horizontalLocation = new HorizontalLocation(0, countOfPerson);
        assertThatThrownBy(horizontalLocation::moveLeft).isInstanceOf(LocationLimitExceedException.class);
    }
}
