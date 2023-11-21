package ladder.domain;

import ladder.domain.exception.LadderException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonNamesTest {

    @Test
    void 이름_길이_초과() {
        Assertions.assertThatExceptionOfType(LadderException.class)
            .isThrownBy(() -> new PersonNames(new String[] {"abcdef"}))
            .withMessage("사람 이름은 최대 5자 입니다.");

    }
}
