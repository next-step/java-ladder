package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpectTest {

    @Test
    public void 만들기() {
        final String input = "당첨";
        Expect expect = new Expect(input);

        assertThat(expect.getValue()).isEqualTo(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 빈문자열_생성() {
        final String emptyString = "";

        new Expect(emptyString);
    }

    @Test
    public void formattedValue() {
        final String length5 = "12345";
        final String length7 = "1234567";

        Expect expect5 = new Expect(length5);
        Expect expect7 = new Expect(length7);

        assertThat(expect5.formattedValue().length()).isEqualTo(6);
        assertThat(expect7.formattedValue().length()).isEqualTo(length7.length());
    }

}