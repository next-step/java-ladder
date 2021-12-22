package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static final int VALID_HEIGHT_OF_LADDER = 5;

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = Ladder.initate(UsersTest.USERS.size(), VALID_HEIGHT_OF_LADDER);
    }

    @Test
    void initTest() {
        // then
        assertThat(ladder).isNotNull();
    }

    @Test
    void getLaddersTest() {
        // when & then
        assertThat(ladder.getLadders()).hasSize(VALID_HEIGHT_OF_LADDER);
    }
}
