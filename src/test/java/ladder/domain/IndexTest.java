package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Type;
import ladder.exception.InvalidBoundIndexException;
import ladder.exception.NotChangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IndexTest {

    public static final Index ZERO_INDEX = new Index(1, 0);
    public static final Index ONE_INDEX = new Index(1, 1);

    @Test
    @DisplayName("0 보다 작은 Index 으로 생성할 경우 InvalidBoundIndexException 를 반환한다.")
    void invalidIndex_Min() {
        assertThatThrownBy(() -> new Index(1, -1))
                .isInstanceOf(InvalidBoundIndexException.class)
                .hasMessage("0 ~ 1 사이의 값만 가능합니다.");
    }

    @Test
    @DisplayName("최댓값 보다 큰 Index 으로 생성할 경우 InvalidBoundIndexException 를 반환한다.")
    void invalidPosition_Max() {
        assertThatThrownBy(() -> new Index(1, 2))
                .isInstanceOf(InvalidBoundIndexException.class)
                .hasMessage("0 ~ 1 사이의 값만 가능합니다.");
    }

    @Test
    @DisplayName("Index 값이 최솟값일때 왼쪽으로 변경하면 예외를 반환한다.")
    void invalidChangeLeft() {
        Index index = new Index(2, 0);

        assertThatThrownBy(() -> index.change(Direction.LEFT))
                .isInstanceOf(NotChangeException.class)
                .hasMessage("현재 위치가 최소 혹은 최대이라서 변경할 수 없습니다. 최솟값=0, 최댓값=2, 현재 위치=0");
    }

    @Test
    @DisplayName("왼쪽으로 이동하면 Index 값이 1 감소한다.")
    void down() {
        Index index = new Index(2, 1);

        index.change(Direction.LEFT);

        assertThat(index).isEqualTo(new Index(2, 0));
    }

    @Test
    @DisplayName("Index 값이 최댓값일때 오른쪽으로 변경하면 예외를 반환한다.")
    void invalidChangeRight() {
        Index index = new Index(2, 2);

        assertThatThrownBy(() -> index.change(Direction.RIGHT))
                .isInstanceOf(NotChangeException.class)
                .hasMessage("현재 위치가 최소 혹은 최대이라서 변경할 수 없습니다. 최솟값=0, 최댓값=2, 현재 위치=2");
    }

    @Test
    @DisplayName("오른쪽으로 이동하면 Index 값이 1 증가한다.")
    void up() {
        Index index = new Index(2, 1);

        index.change(Direction.RIGHT);

        assertThat(index).isEqualTo(new Index(2, 2));
    }

}