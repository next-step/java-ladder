package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {

    @Test
    public void 만들기() {
        final List<GameResult> list = Arrays.asList(new GameResult(new Name("a"), new Expect("a")));

        GameResults gameResults = new GameResults(list);

        assertThat(gameResults.size()).isEqualTo(list.size());
    }

    @Test
    public void getStringGameResults() {
        final String expected = "a : a" + System.lineSeparator() + "b : b" + System.lineSeparator();
        final List<GameResult> list = Arrays.asList(
                new GameResult(new Name("a"), new Expect("a")),
                new GameResult(new Name("b"), new Expect("b"))
        );

        GameResults gameResults = new GameResults(list);

        assertThat(gameResults.getStringGameResults()).isEqualTo(expected);
    }

}