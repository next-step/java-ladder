package nextstep.ladder.step4.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.step4.exception.ArgumentNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAsSplitTest {

    @ParameterizedTest
    @DisplayName("생성성공")
    @CsvSource(value = {"pobi,honux,crong,jk:4", "kim,dong,hyo:3"}, delimiter = ':')
    void create(String input, int size) {
        assertThat(new StringAsSplit(input).split().length).isEqualTo(size);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 값일 경우")
    void exception(String input) {
        assertThatExceptionOfType(ArgumentNullPointerException.class)
            .isThrownBy(() -> new StringAsSplit(input));
    }

}
