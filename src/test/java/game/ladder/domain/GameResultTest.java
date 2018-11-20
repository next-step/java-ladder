package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 만들기() {
        final Name name = new Name("name");
        final Expect expect = new Expect("e1");

        GameResult gameResult = new GameResult(name, expect);
    }

    @Test
    public void getStringResult() {
        final String expected = "name : e1";
        final Name name = new Name("name");
        final Expect expect = new Expect("e1");

        GameResult gameResult = new GameResult(name, expect);

        assertThat(gameResult.getStringResult()).isEqualTo(expected);
    }

}