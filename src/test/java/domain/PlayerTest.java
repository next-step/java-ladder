package domain;

import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class PlayerTest {

    @SuppressWarnings("SpellCheckingInspection")
    @Test(expected = IllegalArgumentException.class)
    public void 이름_NULL인_경우_예외를_던진다() {
        new Player(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름이_빈문자열이면_예외를_던진다() {
        new Player("");
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test(expected = IllegalArgumentException.class)
    public void 이름의_길이는_5글자를_넘을수_없다() {
        new Player("Ninezero");
    }

}
