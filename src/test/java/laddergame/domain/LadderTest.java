package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    private final Ladder ladder = new Ladder(List.of(
            new LadderLine(List.of(true, false, false)),
            new LadderLine(List.of(true, false, true)),
            new LadderLine(List.of(false, false, false))
    ));

    @DisplayName("사다리의 가로 라인 리스트를 전달하면, 예외가 발생하지 않고 사다리가 생성되어야 한다.")
    @Test
    void create() {
        assertThatNoException()
                .isThrownBy(() -> {
                    assertThat(new Ladder(List.of(
                            new LadderLine(List.of(false, true, false)),
                            new LadderLine(List.of(true, false, false))
                    ))).isNotNull();
                });
    }

    @DisplayName("높이 인덱스를 전달하면, 해당 높이 인덱스의 사다리 가로 라인을 반환해야 한다.")
    @Test
    void getLine() {
        assertThat(ladder.getLine(0)).isEqualTo(new LadderLine(List.of(true, false, false)));
        assertThat(ladder.getLine(1)).isEqualTo(new LadderLine(List.of(true, false, true)));
        assertThat(ladder.getLine(2)).isEqualTo(new LadderLine(List.of(false, false, false)));
    }

    @DisplayName("높이 인덱스의 범위를 벗어나는 값을 전달하면, 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void getLine_givenIndexOutOfRange(int index) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> ladder.getLine(index));
    }

    @DisplayName("사다리의 높이를 반환해야 한다.")
    @Test
    void getHeight() {
        assertThat(ladder.getHeight()).isEqualTo(3);
    }

    @DisplayName("다음 라인으로 이동할 때, 오른쪽으로 연결되어 있다면 1 증가해야 한다.")
    @Test
    void moveToNextLine_whenRightConnected() {
        assertThat(ladder.moveToNextLine(0, 0)).isEqualTo(1);
    }

    @DisplayName("다음 라인으로 이동할 때, 왼쪽으로 연결되어 있다면 1 감소해야 한다.")
    @Test
    void moveToNextLine_whenLeftConnected() {
        assertThat(ladder.moveToNextLine(0, 1)).isEqualTo(0);
    }

    @DisplayName("다음 라인으로 이동할 때, 아무것도 연결되어 있지 않다면 그 자리에 있어야 한다.")
    @Test
    void moveToNextLine_whenNotConnected() {
        assertThat(ladder.moveToNextLine(2, 1)).isEqualTo(1);
    }

    @DisplayName("처음 위치가 주어졌을 때, 마지막 라인까지 이동했을 때의 위치를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "2,3",
            "3,2"
    })
    void moveToLastLine(int indexOfFirstPosition, int expected) {
        assertThat(ladder.moveToLastLine(indexOfFirstPosition)).isEqualTo(expected);
    }

}
