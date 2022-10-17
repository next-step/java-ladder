package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    private static final String NORMAL_NAME = "mojh";
    private static final String ERROR_NAME = "mojh123";

    @Test
    @DisplayName("이름을 생성할 때 정상적인 값을 넣었을 때 정상적으로 생성되어지는지에 대한 테스트")
    public void constructorSuccessTest() {
        assertThat(new Name(NORMAL_NAME)).isEqualTo(new Name(NORMAL_NAME));
    }

    @Test
    @DisplayName("이름을 생성할 떄 5자를 초과할 경우 에러를 발생되어지는지에 대한 테스트")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new Name(ERROR_NAME)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "이름을 생성할 때 Null 혹은 빈값을 넣을 경우 에러를 발생한다.")
    @NullAndEmptySource
    void constructorTestNullOrBlank(String text) {
        assertThatThrownBy(() -> new Name(text)).isInstanceOf(IllegalArgumentException.class);
    }

}