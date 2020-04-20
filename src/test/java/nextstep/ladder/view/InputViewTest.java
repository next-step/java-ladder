package nextstep.ladder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private String userNames = "pobi,honux,crong,jk";

    @DisplayName("참여할 사람 이름을 입력하지 않는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "all" })
    @NullAndEmptySource
    void validateUserNames(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.splitByComma(names);
        });
    }

    @DisplayName("입력받은 이름을 ,로 자른다.")
    @Test
    void splitUserNamesByComma() {
        String[] names = InputView.splitByComma(userNames);
        assertThat(names).hasSize(4);
    }
}
