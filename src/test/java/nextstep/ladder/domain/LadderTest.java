package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.Bridges.FALSE_BRIDGE;
import static nextstep.ladder.domain.Bridges.TRUE_BRIDGE;
import static nextstep.ladder.domain.Ladder.LADDER_POLE;
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
        assertThat(stringLadder).isEqualTo(
            LADDER_POLE+ TRUE_BRIDGE + LADDER_POLE + FALSE_BRIDGE + LADDER_POLE + TRUE_BRIDGE + LADDER_POLE + "\n" +
                LADDER_POLE+ TRUE_BRIDGE + LADDER_POLE + FALSE_BRIDGE + LADDER_POLE + TRUE_BRIDGE + LADDER_POLE
        );
    }
}
