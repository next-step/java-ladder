package ladder;

import ladder.domain.*;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    public final RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
        @Override
        public boolean randomBoolean() {
            return true;
        }
    };

    @Test
    public void ganeResultTest() {
        // given
        final int line = 6;
        final int height = 3;
        Ladder ladder = Ladder.valueOf(line, height, randomTrueBoolean);

        final Players players = Players.valueOf(Arrays.asList("a", "b", "c", "d", "e", "f"));
        final Rewards rewards = Rewards.valueOf(Arrays.asList("1등", "2등", "3등", "4등", "5등", "6등"));

        LadderEdge ladderEdge = new LadderEdge(players, rewards);

        Map<Player, Reward> expectResult = new HashMap<>();
        expectResult.put(new Player("a"), new Reward("2등"));
        expectResult.put(new Player("b"), new Reward("1등"));
        expectResult.put(new Player("c"), new Reward("4등"));
        expectResult.put(new Player("d"), new Reward("3등"));
        expectResult.put(new Player("e"), new Reward("6등"));
        expectResult.put(new Player("f"), new Reward("5등"));

        LadderGame expectLadderGame = new LadderGame(expectResult);

        //when
        LadderGame resultLadderGame = LadderGame.valueOf(ladderEdge, ladder);

        // then
        assertThat(resultLadderGame).isEqualTo(expectLadderGame);
    }

    @Test
    public void printGameResult() {
        //given
        Map<Player, Reward> game = new HashMap<>();
        game.put(new Player("a"), new Reward("2등"));
        game.put(new Player("b"), new Reward("1등"));
        game.put(new Player("c"), new Reward("3등"));
        LadderGame ladderGame = new LadderGame(game);
        StringBuilder expectPrintGameResult = new StringBuilder();
        expectPrintGameResult.append("a : 2등").append(System.lineSeparator())
                .append("b : 1등").append(System.lineSeparator())
                .append("c : 3등").append(System.lineSeparator());

        //when
        String printGameResult = ladderGame.printGameResult();

        //then
        assertThat(printGameResult).isEqualTo(expectPrintGameResult.toString());
    }
}
