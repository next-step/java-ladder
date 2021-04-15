package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class MembersTest {

    @Test
    void create() {
        assertThatCode(() -> Members.of("pobi,honux,crong,jk")).doesNotThrowAnyException();
    }

    @Test
    void findHorizontalNumber() {
        Members members = Members.of("pobi,honux,crong,jk");
        assertThat(members.findHorizontalNumber(Member.of("honux"))).isEqualTo(1);
    }
}
