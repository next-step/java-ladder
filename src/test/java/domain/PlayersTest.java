package domain;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
public class PlayersTest {

    @Test(expected = IllegalArgumentException.class)
    public void 참가자가_공백인_경우_예외를_던진다() {
        new Players("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참가자가_NULL인_경우_예외를_던진다() {
        new Players(null);
    }

    @Test
    public void 콤마를_구분자로_입력한_참가자가_만들어졌는지_검사() {
        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        assertThat(players.size()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참가자_이름이_중복이면_예외를_던진다() {
        new Players("홍길동,홍길동,나인제로,둘리");
    }

    @Test
    public void 참가자_이름으로_인덱스를_구한다() {
        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        final int index = players.findByName("홍길동");
        assertThat(index).isEqualTo(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void 참가자_이름으로_인덱스를_구하지_못하는_경우() {
        final Players players = new Players("홍길동,홍길순,나인제로,둘리");
        players.findByName("마이콜");
    }

}