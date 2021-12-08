package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void 이름을_생성한다() {
        //given
        Name name = Name.of("hello");
        //when
        //then
        assertThat(name).isEqualTo(Name.of("hello"));
    }

    @Test
    void 이름의_길이가_5자를_초과하면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Name.of("python"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
