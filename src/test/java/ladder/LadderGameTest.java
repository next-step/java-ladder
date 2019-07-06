package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LadderGameTest {
    static final String INPUT_USER_NAMES = "pobi,honux,crong,jk";
    static final String INPUT_USER_NAMES_INVALID_LENGTH = "toolongname,honux,crong,jk";
    static final String INPUT_USER_RESULTS = "a,b,c,d";
    static final int INPUT_LADDER_HEIGHT = 1;

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        ladderGame = new LadderGame(INPUT_USER_NAMES, INPUT_USER_RESULTS, INPUT_LADDER_HEIGHT);
    }

    @Test
    void too_long_user_name() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LadderGame(INPUT_USER_NAMES_INVALID_LENGTH, INPUT_USER_RESULTS, INPUT_LADDER_HEIGHT);
        });
    }
}