package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LadderNamesTest {
    @Test
    void create() {
        LadderNames ladderNames = LadderNames.of("a,b,c,d");
        assertThat(ladderNames).isEqualTo(LadderNames.of("a,b,c,d"));
    }

}
