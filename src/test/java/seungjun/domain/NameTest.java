package seungjun.domain;

import seungjun.ladder.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @Test
    @DisplayName("[Name.equals] 같은 사람 이름이면 -> 동일 판정")
    public void same() {
        assertThat(new Name("mymy"))
                .isEqualTo(new Name("mymy"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("[Name.new] 사람 이름이 1~5자가 아니면 -> 예외 던짐")
    public void wrongNameLength(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Name(name);
                });
    }

    @Test
    @DisplayName("[Name.new] 이름에 null이 오면 -> 예외 던짐")
    public void nullName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Name(null);
                });
    }
}
