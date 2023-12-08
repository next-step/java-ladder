package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private static final Brace BRACE_LEFT = new Brace(true, false);
    private static final Brace BRACE_RIGHT = new Brace(false, true);
    private static final Brace BRACE_NONE = new Brace(false, false);

    private Line firstLine;
    private Line secondLine;
    private Line thirdLine;
    private Line fourthLine;
    private String[] inputPlayers;
    private String[] inputAmounts;

    @BeforeEach
    void setUp() {
        firstLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
        secondLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
        thirdLine = new Line(List.of(BRACE_NONE, BRACE_RIGHT, BRACE_LEFT, BRACE_NONE));
        fourthLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
        inputPlayers = "a,b,c,d".split(",");
        inputAmounts = "1,2,3,4".split(",");
    }

    @Test
    void success() {
        Players players = new Players(inputPlayers);
        Ladder ladder = new Ladder(List.of(firstLine, secondLine, thirdLine, fourthLine));
        Amounts amounts = new Amounts(inputAmounts);
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
