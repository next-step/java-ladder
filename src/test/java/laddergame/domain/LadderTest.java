package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

}
