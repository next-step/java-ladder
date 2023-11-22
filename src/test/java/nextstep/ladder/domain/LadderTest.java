package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadder() {
        assertThat(new Ladder(List.of(
            List.of(true, false, true),
            List.of(false, true, false)
        ))).isEqualTo(new Ladder(List.of(
            List.of(true, false, true),
            List.of(false, true, false))));
    }

    @DisplayName("사다리의 높이와 다리의 위치 값을 인자로 받아 해당 다리가 이동 가능한 지 확인한다.")
    @ParameterizedTest
    @CsvSource({"0,0,true", "1,0,false", "2,0,true", "0,1,true", "1,1,false", "2,1,true"})
    void isMovable(int xAxis, int yAxis, boolean expected) {
        // given
        Ladder ladder = new Ladder(List.of
            (List.of(true, false, true),
             List.of(true, false, true)));

        // when & then
        assertThat(ladder.isMovable(xAxis, yAxis)).isEqualTo(expected);
    }
}
