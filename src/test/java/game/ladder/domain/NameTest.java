package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    public void 만들기() {
        final String value = "name";
        Name name = new Name(value);

        assertThat(name.getValue()).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름이_공백일때() {
        final String emptyValue = "";

        new Name(emptyValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름이_6자일때() {
        final String value = "123456";

        new Name(value);
    }

    @Test
    public void 포메팅된_이름() {
        Name name = new Name("name");

        assertThat(name.fomattedName().length()).isEqualTo(6);
    }

    @Test
    public void isEqualValue() {
        final String all = "all";

        assertThat(Name.ALL.isEqualValue(all)).isTrue();
    }

}