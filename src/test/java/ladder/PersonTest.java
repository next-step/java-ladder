package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {

    @Test
    public void 이름이_5자를_초과할_경우_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Person("이름이름이름"));
        ;
    }
}