package nextstep.ladder.domain;


import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    void 잘못된_높이() {
        List<Line> lines = Ladder.createRandomLines(0, 2, new Random());
        assertThatThrownBy(() -> new Ladder(0, 2, lines))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("사다리의 높이는 1보다 작을 수 없습니다.");
    }

    @Test
    void 잘못된_폭() {
        List<Line> lines = Ladder.createRandomLines(1, 1, new Random());
        assertThatThrownBy(() -> new Ladder(1, 1, lines))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("사다리의 폭은 2보다 작을 수 없습니다.");
    }

    @Test
    void 잘못된_가로선_갯수() {
        List<Line> lines = Ladder.createRandomLines(2, 2, new Random());
        assertThatThrownBy(() -> new Ladder(1, 2, lines))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("사다리의 높이와 가로선의 갯수는 같아야 합니다.");
    }

    @Test
    void 잘못된_가로선_폭() {
        List<Line> lines = Ladder.createRandomLines(1, 3, new Random());

        assertThatThrownBy(() -> new Ladder(1, 2, lines))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("사다리의 폭-1 과 가로선의 폭은 같아야 합니다.");

        assertThatThrownBy(() -> new Ladder(1, 4, lines))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("사다리의 폭-1 과 가로선의 폭은 같아야 합니다.");
    }

    @Test
    void 랜덤_사다리_생성() {
        Ladder ladder = Ladder.createRandomLadder(1, 2, new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        });

        assertThat(ladder).isEqualTo(new Ladder(
                1, 2, List.of(
                        new Line(List.of(true))
        )
        ));
    }

    @Test
    void 결과_찾기() {
        /*
          0     1     2
          |-----|     |
          |     |-----|
          |-----|     |
          0     1     2
         */
        Ladder ladder = new Ladder(3, 3, List.of(
                new Line(List.of(true, false)),
                new Line(List.of(false, true)),
                new Line(List.of(true, false))
        ));

        assertThat(ladder.findEndPosition(0)).isEqualTo(2);
        assertThat(ladder.findEndPosition(1)).isEqualTo(1);
        assertThat(ladder.findEndPosition(2)).isEqualTo(0);
    }
}