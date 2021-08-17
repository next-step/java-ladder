package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.LengthLimitException;
import nextstep.ladder.exception.NoSearchPersonException;
import org.junit.jupiter.api.Test;

public class LadderNamesTest {
    @Test
    void create() {
        LadderNames ladderNames = LadderNames.of("a,b,c,d");
        assertThat(ladderNames).isEqualTo(LadderNames.of("a,b,c,d"));
    }

    @Test
    void createException() {
        assertThatThrownBy(() -> {
            LadderNames.of("aaaaaa,test,test1,test2");
        }).isInstanceOf(LengthLimitException.class);
    }

    @Test
    void findNameTest() {
        LadderNames ladderNames = LadderNames.of("a,b,c,d");
        assertThatThrownBy(() -> {
            ladderNames.findName("e");
        }).isInstanceOf(NoSearchPersonException.class);
    }
}
