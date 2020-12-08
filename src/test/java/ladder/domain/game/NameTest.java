package ladder.domain.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-03.
 */
public class NameTest {

    @Test
    @ValueSource()
    void 참여할_사람_이름을_입력하기() {
        Name name = Name.from("가나다라");
        assertThat(name).isEqualTo(Name.from("가나다라"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 참여할_사람_이름이_빈칸이면_예외(String inputName) {
        assertThatThrownBy(() -> Name.from(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Name.MESSAGE_NAME_NOT_NULL);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바"})
    void 참여할_사람_이름이_5자를_넘어가면_예외(String inputName) {
        assertThatThrownBy(() -> Name.from(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                ;
    }

}
