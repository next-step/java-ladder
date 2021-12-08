package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    void 이름의_길이가_1자_미만_5자를_초과하면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertAll(
                () -> assertThatThrownBy(() -> Name.of(""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Name.of("python"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
