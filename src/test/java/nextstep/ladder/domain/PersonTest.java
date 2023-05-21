package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PersonTest {

    @Test
    void create() {
        Person pobi = new Person("pobi");
        assertThat(pobi.name()).isEqualTo(new Person("pobi").name());
    }

    @Test
    void 글자수_5이상시_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Person("hoyeon"))
                .withMessageContaining("글자수는 최대 5글자까지 부여할 수 있습니다.");
    }

}
