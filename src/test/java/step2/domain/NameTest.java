package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void 이름을_생성한다() {
        //given
        String input = "java";
        //when
        Name name = Name.of(input);
        //then
        assertThat(name).isNotNull();
        assertThat(name).isEqualTo(Name.of(input));
    }

    @Test
    void 이름의_길이가_5초과면_IllegalArgumentException_이_발생한다() {
        //given
        assertThatThrownBy(() -> Name.of("nextstep"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
