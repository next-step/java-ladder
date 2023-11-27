package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @DisplayName("Ladder로 포장된 값을 String 타입의 사다리 모양으로 변환해 반환한다.")
    @Test
    void ladderToBoolean() {
        // given
        Ladder ladder = new Ladder(List.of
            (new Bridges(List.of(true, false, true)),
             new Bridges(List.of(true, false, true))));

        // when
        String stringLadder = ladder.toString();

        // then
        assertThat(stringLadder).isEqualTo("|-----|     |-----|\n|-----|     |-----|");
    }

    @DisplayName("인자로 시작 위치를 전달 받아 사다리를 타고 결과 위치를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,2","1,0","2,1","3,3"})
    void climb(int startPosition, int expectedResult) {
        Ladder ladder = new Ladder(List.of(
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, false)),
            new Bridges(List.of(false, false, false)),
            new Bridges(List.of(false, true, false))
        ));

        // when
        int result = ladder.climb(startPosition);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
