package ladder.domain.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {

    @Test
    @DisplayName("이름을 받아 새로운 사다리 결과를 생성한다.")
    void Item_Name() {
        assertThat(new Item("item"))
                .isEqualTo(new Item("item"));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("사다리 결과 이름이 null인 경우 예외를 던진다.")
    void Item_NullName_Exception(final String nullName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Item(nullName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n", "  \n  "})
    @DisplayName("사다리 결과 이름이 빈 문자열, 공백, 개행인 경우 예외를 던진다.")
    void Item_BlankName_Exception(final String blankName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Item(blankName));
    }
}
