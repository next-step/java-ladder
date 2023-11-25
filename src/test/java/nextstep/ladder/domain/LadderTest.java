package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @AfterEach
    void clear() {
        Coordinate.clear();
    }

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

    @DisplayName("인자로 플레이어를 받아 사다리를 타게한다. 사다리 타기가 완료된 플레이어를 반환한다.")
    @Test
    void climb() {
        Ladder ladder = new Ladder(List.of
            (new Bridges(List.of(true, false, true)),
             new Bridges(List.of(true, false, true))));
        Coordinate.init(new Width(4), new Height(2));
        Player player = new Player("홍길동", Coordinate.of(0, 0));

        // when
        Player finished = ladder.climb(player);

        // then
        assertThat(finished.isEqualCoordinate(Coordinate.of(0, 2))).isTrue();
    }
}
