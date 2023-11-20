package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    void 사다리_게임에_참여하는_사람에_이름을_최대5글자까지_부여할_수_있다() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"null", "''"}, nullValues = {"null"})
    void 사다리_게임에_참여하는_사람에_이름은_비어있을_수_없다(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
