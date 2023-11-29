package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @DisplayName("Ladder로 포장된 값을 String 타입의 사다리 모양으로 변환해 반환한다.")
    @Test
    void ladderToBoolean() {
        // given
        Ladder ladder = new Ladder(List.of(
            new Points(List.of(
                new Point(0, RIGHT),
                new Point(1, LEFT),
                new Point(2, CENTER)
            )),
            new Points(List.of(
                new Point(0, CENTER),
                new Point(1, RIGHT),
                new Point(2, LEFT)
            ))
        ));

        // when
        String stringLadder = ladder.toString();

        // then
        assertThat(stringLadder).isEqualTo("|-----|     |" + "\n" + "|     |-----|");
    }

    @DisplayName("인자로 시작 위치를 전달 받아 사다리를 타고 결과 위치를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,3","1,2","2,1","3,0"})
    void climb(int startPosition, int expectedResult) {
        Ladder ladder = new Ladder(List.of(
            new Points(List.of(
                new Point(0, RIGHT),
                new Point(1, LEFT),
                new Point(2, RIGHT),
                new Point(3, LEFT)
            )),
            new Points(List.of(
                new Point(0, CENTER),
                new Point(1, RIGHT),
                new Point(2, LEFT),
                new Point(3, CENTER)
            )),
            new Points(List.of(
                new Point(0, RIGHT),
                new Point(1, LEFT),
                new Point(2, RIGHT),
                new Point(3, LEFT)
            )),
            new Points(List.of(
                new Point(0, CENTER),
                new Point(1, RIGHT),
                new Point(2, LEFT),
                new Point(3, CENTER)
            ))
        ));

        // when
        int result = ladder.climb(startPosition);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
