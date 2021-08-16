package nextstep.ladder.domain;

import nextstep.ladder.exception.LengthLimitException;
import nextstep.ladder.exception.NoSearchPersonException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {
    @Test
    void create() {
        Names ladderNames = Names.of("a,b,c,d");
        assertThat(ladderNames).isEqualTo(Names.of("a,b,c,d"));
    }

    @Test
    void createException() {
        assertThatThrownBy(() -> {
            Names.of("aaaaaa,test,test1,test2");
        }).isInstanceOf(LengthLimitException.class);
    }

    @Test
    void findNameTest() {
        Names ladderNames = Names.of("a,b,c,d");
        assertThatThrownBy(() -> {
            ladderNames.findName("e");
        }).isInstanceOf(NoSearchPersonException.class);
    }
}
