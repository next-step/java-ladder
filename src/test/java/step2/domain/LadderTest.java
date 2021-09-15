package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.Players;

import java.util.Arrays;
import java.util.List;

class LadderTest {

    @Test
    @DisplayName("출력 확인용 테스트")
    void createTest1() {
        final Players players = new Players(new String[]{"a", "b", "c", "d"});
        final List<Line> lines = Arrays.asList(new Line(players.size()),
                new Line(players.size()),
                new Line(players.size()),
                new Line(players.size()));
        final Ladder ladder = new Ladder(players, lines);
        System.out.println(ladder.print());
    }

    @Test
    @DisplayName("출력 확인용 테스트")
    void createTest2() {
        final Players players = new Players(new String[]{"a", "b", "c", "d"});
        final List<Line> lines = Arrays.asList(
        new Line(Arrays.asList(false, true, false, true)),
        new Line(Arrays.asList(false, false, true, false)),
        new Line(Arrays.asList(false, true, false, false)),
        new Line(Arrays.asList(false, false, true, false)),
        new Line(Arrays.asList(false, true, false, true)));
        final Ladder ladder = new Ladder(players, lines);
        System.out.println(ladder.print());
    }
}