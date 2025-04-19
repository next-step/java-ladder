package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    public static final int COUNT_OF_PERSON = 5;

    @Test
    void newLine(){
        assertThat(new Line(COUNT_OF_PERSON).getPoints().size()).isEqualTo(COUNT_OF_PERSON-1);
    }
}
