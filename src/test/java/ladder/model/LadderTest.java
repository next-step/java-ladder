package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성된다")
    void of() {
        assertThat(Ladder.of(5, 4, new RandomStrategy())).isInstanceOf(Ladder.class);
    }

    /**
     * |-----|     |
     * |     |-----|
     */
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
    @DisplayName("사다리에서 참여자의 인덱스를 입력하면 실행 결과 인덱스를 반환한다")
    void move(int inputIndex, int expectedIndex) {
        //given
        Ladder ladder = Ladder.create(List.of(
                Line.create(List.of(
                        Point.of(0, Direction.of(false, true)),
                        Point.of(0, Direction.of(true, false)),
                        Point.of(0, Direction.of(false, false)))),
                Line.create(List.of(
                        Point.of(1, Direction.of(false, false)),
                        Point.of(1, Direction.of(false, true)),
                        Point.of(1, Direction.of(true, false)))))
        );

        //when
        int resultIndex = ladder.move(inputIndex);

        //then
        assertThat(resultIndex).isEqualTo(expectedIndex);

    }

}
