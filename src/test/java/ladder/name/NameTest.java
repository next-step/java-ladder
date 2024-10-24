package ladder.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @DisplayName("사다리 게임 참여자 이름을 만들 수 있다.")
    @Test
    void create() {
        Name answer = new Name("green");

        assertThat(answer).isEqualTo(new Name("green"));
    }

    @DisplayName("사다리 게임 참여자 이름이 없으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createWithEmptyName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @DisplayName("사다리 게임 참여자 이름이 없으면 예외가 발생한다.")
    @Test
    void createWithMaximumNameLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("banana"));
    }
}
