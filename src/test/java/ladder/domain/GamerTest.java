package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamerTest {
    @ParameterizedTest
    @DisplayName("빈 이름이거나, 6자 이상 이름, null 예외처리")
    @ValueSource(strings = {"Player", "Un i t"})
    @EmptySource
    @NullSource
    void expectException(String name) {
        assertThatThrownBy(() -> getGamer(name))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("정상 적인 이름들 인지 확인")
    @ValueSource(strings = {"Unit", " Unit1 ", "m   e", "Unit1 ", " m    e   "})
    void getNameTest() {
        String name = "tj";
        assertThat(getGamer(name).getName())
                .isEqualTo(name);
    }

    private Gamer getGamer(String name) {
        return Gamer.of(name, 1);
    }
}
