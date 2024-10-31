package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {

    @Test
    void 이름_5자_이상_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Person("jeonghyeon")
        );
    }

    @Test
    void 공백_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Person(" ")
        );

    }
}
