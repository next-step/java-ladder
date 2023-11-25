package ladder.domain;

import ladder.domain.exception.LadderException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void 이름_길이_초과() {
        Assertions.assertThatExceptionOfType(LadderException.class)
            .isThrownBy(() -> new Name("abcdef"))
            .withMessage("사람 이름은 1자 이상 5자 이하 입니다.");

    }
}
