package nextstep.ladder.participant;

import nextstep.ladder.domain.participant.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NameTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final Name name = new Name("12345");

        assertThat(name)
                .isEqualTo(new Name("12345"));
    }

    @Test
    @DisplayName("null, 빈값, 5자를 초과하는 이름은 exception")
    void nameLongerThan5() {
        assertAll(
                () -> assertThatThrownBy(() -> new Name(null))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Name(""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Name(" "))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Name("123456"))
                        .isInstanceOf(IllegalArgumentException.class)
        );


    }
}
