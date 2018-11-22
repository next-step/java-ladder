package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class PlayersTest {

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_값이_공백인_경우_예외를_던진다() {
        new Players("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_값이_NULL인_경우_예외를_던진다() {
        new Players(null);
    }

    @Test
    public void 콤마를_구분자로_입력한_사용자가_만들어졌는지_검사() {
        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        assertThat(players.calculatorPlayersLength()).isEqualTo(3);
    }

}