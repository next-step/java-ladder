package nextstep.ladder.domain;

import nextstep.ladder.fixtures.BraceFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private Line firstLine;
    private Line secondLine;
    private Line thirdLine;
    private Line fourthLine;
    private String[] inputPlayers;
    private String[] inputAmounts;

    @BeforeEach
    void setUp() {
        firstLine = new Line(List.of(BraceFixtures.right(), BraceFixtures.left(), BraceFixtures.none(), BraceFixtures.none()));
        secondLine = new Line(List.of(BraceFixtures.right(), BraceFixtures.left(), BraceFixtures.none(), BraceFixtures.none()));
        thirdLine = new Line(List.of(BraceFixtures.none(), BraceFixtures.right(), BraceFixtures.left(), BraceFixtures.none()));
        fourthLine = new Line(List.of(BraceFixtures.right(), BraceFixtures.left(), BraceFixtures.none(), BraceFixtures.none()));
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
