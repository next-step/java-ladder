package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class MembersTest {

    @Test
    void create() {
        assertThatCode(() -> Members.from("pobi,honux,crong,jk")).doesNotThrowAnyException();
    }
}
