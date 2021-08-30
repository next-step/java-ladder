package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LadderGameTest {

    @Test
    void create() {
        new LadderGame(Arrays.asList("pohi", "honux", "crong"), 5);
    }
}