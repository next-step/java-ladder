package laddergame.component;

import laddergame.domain.Ladder;
import laddergame.domain.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {

    @DisplayName("사다리 세로 막대의 개수와 높이가 주어지면, 해당 크기의 사다리가 생성되어야 한다.")
    @Test
    void createLadder() {
        LadderFactory ladderFactory = new LadderFactory(numberOfColumns -> new LadderLine(List.of(true, false, true)));
        Ladder actual = ladderFactory.createLadder(4, 2);
        assertThat(actual).isEqualTo(
                new Ladder(List.of(
                        new LadderLine(List.of(true, false, true)),
                        new LadderLine(List.of(true, false, true))
                ))
        );
    }

}
