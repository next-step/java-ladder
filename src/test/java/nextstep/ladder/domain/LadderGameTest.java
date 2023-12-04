package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private final static Brace BRACE_FALSE_TRUE = new Brace(Point.FALSE, Point.TRUE);
    private final static Brace BRACE_TRUE_FALSE = new Brace(Point.TRUE, Point.FALSE);
    private final static Brace BRACE_FALSE_FALSE = new Brace(Point.FALSE, Point.FALSE);

    private Line firstLine;
    private Line secondLine;
    private Line thirdLine;
    private Line fourthLine;

    @BeforeEach
    void setUp() {
        firstLine = new Line(List.of(BRACE_FALSE_TRUE, BRACE_TRUE_FALSE, BRACE_FALSE_FALSE, BRACE_FALSE_FALSE));
        secondLine = new Line(List.of(BRACE_FALSE_TRUE, BRACE_TRUE_FALSE, BRACE_FALSE_FALSE, BRACE_FALSE_FALSE));
        thirdLine = new Line(List.of(BRACE_FALSE_FALSE, BRACE_FALSE_TRUE, BRACE_TRUE_FALSE, BRACE_FALSE_FALSE));
        fourthLine = new Line(List.of(BRACE_FALSE_TRUE, BRACE_TRUE_FALSE, BRACE_FALSE_FALSE, BRACE_FALSE_FALSE));
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
