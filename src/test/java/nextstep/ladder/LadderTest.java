package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    public static final int COUNT_OF_PERSON = 5;
    public static final int HEIGHT = 5;

    @Test
    void newLadder(){
        assertThat(new Ladder(COUNT_OF_PERSON, HEIGHT).getLines().size()).isEqualTo(HEIGHT);
    }

}
