package ladder.model;

import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class DifficultTest {

    @Test
    public void 난이도_상() {
        Difficult difficult = Difficult.of("상");

        assertThat(difficult).isEqualTo(Difficult.HIGH);
    }

    @Test
    public void 난이도_중() {
        Difficult difficult = Difficult.of("중");

        assertThat(difficult).isEqualTo(Difficult.MIDDLE);
    }
    @Test
    public void 난이도_하() {
        Difficult difficult = Difficult.of("하");

        assertThat(difficult).isEqualTo(Difficult.LOW);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 난이도_그외_입력() {
        Difficult.of("아무개");
    }


}