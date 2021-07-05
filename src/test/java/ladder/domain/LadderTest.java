package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LadderTest {


    private Ladder ladder;

    @BeforeEach
    void setUp() {
        int countOfPerson = 5;
        int ladderHeight = 4;
        ladder = new Ladder(ladderHeight, countOfPerson);

    }

    @Test
    void testToString() {
        System.out.println(ladder.toString());
    }
}
