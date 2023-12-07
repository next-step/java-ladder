package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private static final Point POINT_LEFT = new Point(true, false);
    private static final Point POINT_RIGHT = new Point(false, true);
    private static final Point POINT_NONE = new Point(false, false);

    private static final Brace BRACE_LEFT = new Brace(POINT_LEFT);
    private static final Brace BRACE_RIGHT = new Brace(POINT_RIGHT);
    private static final Brace BRACE_NONE = new Brace(POINT_NONE);

    private Line firstLine;
    private Line secondLine;
    private Line thirdLine;
    private Line fourthLine;

    @BeforeEach
    void setUp() {
        firstLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
        secondLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
        thirdLine = new Line(List.of(BRACE_NONE, BRACE_RIGHT, BRACE_LEFT, BRACE_NONE));
        fourthLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
    }

    @Test
    void success() {
        Players players = new Players("a,b,c,d");
        Ladder ladder = new Ladder(List.of(firstLine, secondLine, thirdLine, fourthLine));
        Amounts amounts = new Amounts("1,2,3,4");
        LadderGame ladderGame = new LadderGame(players, ladder, amounts);
        LadderGameResult ladderGameResult = ladderGame.realPlay();

        Amount firstAmount = ladderGameResult.get(new Player("a"));
        Amount secondAmount = ladderGameResult.get(new Player("b"));
        Amount thirdAmount = ladderGameResult.get(new Player("c"));
        Amount fourthAmount = ladderGameResult.get(new Player("d"));
        assertThat(firstAmount).isEqualTo(new Amount("2"));
        assertThat(secondAmount).isEqualTo(new Amount("3"));
        assertThat(thirdAmount).isEqualTo(new Amount("1"));
        assertThat(fourthAmount).isEqualTo(new Amount("4"));
    }
}
