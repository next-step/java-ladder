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
        assertThat(stringLadder).isEqualTo("|-----|     |-----|\n|-----|     |-----|");
    }

    @DisplayName("인자로 사다리의 좌표 값을 전달받아 해당 사다리가 이동 가능한 지 확인한다.")
    @Test
    void isMovable() {
        Ladder ladder = new Ladder(List.of
            (new Bridges(List.of(true, false, true)),
             new Bridges(List.of(true, false, true))));
        int x = 0;
        int y = 1;

        // when
        boolean result = ladder.isMovable(x, y);

        // then
        assertThat(result).isTrue();
    }
}
