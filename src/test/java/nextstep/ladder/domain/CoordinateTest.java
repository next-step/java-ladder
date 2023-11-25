package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

public class CoordinateTest {

    @AfterEach
    void clear() {
        Coordinate.clear();
    }

    @DisplayName("초기화 되지 않은 좌표 값에 접근할 경우 예외를 발생시킨다.")
    @Test
    void accessBeforeInit() {
        assertThatThrownBy(() -> Coordinate.of(1, 2)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(COORDINATE_IS_NOT_INIT.message());
    }

    @DisplayName("사다리의 높이와 너비를 인자로 받아 전체 좌표 값을 미리 생성해두고 정적 팩토리 메서드를 통해 캐싱된 객체를 반환한다.")
    @Test
    void createCoordinate() {
        // given
        Width width = new Width(5);
        Height height = new Height(5);
        Coordinate.init(width, height);

        // when
        int x = 3;
        int y = 2;
        Coordinate result = Coordinate.of(x, y);

        // then
        assertThat(result).isEqualTo(Coordinate.of(3, 2));
    }

    @DisplayName("전체 좌표 값의 범위를 넘어서는 값이 인자로 전달될 경우 예외를 발생시킨다.")
    @Test
    void outOfRange() {
        // given
        Width width = new Width(5);
        Height height = new Height(5);
        Coordinate.init(width, height);

        // when & then
        assertThatThrownBy(() -> Coordinate.of(5, 5)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(COORDINATE_OUR_OF_RANGE.message());
    }

    @DisplayName("좌표 값이 두 번 이상 초기화 될 경우 예외를 발생시킨다.")
    @Test
    void initTwice() {
        // given
        Width width = new Width(5);
        Height height = new Height(5);
        Coordinate.init(width, height);

        // when & then
        assertThatThrownBy(() -> Coordinate.init(new Width(3), new Height(5))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(COORDINATE_IS_INIT.message());
    }
}
