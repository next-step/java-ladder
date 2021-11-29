package step2.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @Test
    void 입력_값이_숫자로만_이루어져_있는지_검증한다() {
        //given
        String input = "123123";
        //when
        boolean result = input.chars().allMatch(Character::isDigit);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void 입력_값이_숫자_이외의_값이_포함된_경우를_검증한다() {
        //given
        String input = "123123a";
        //when
        boolean result = input.chars().allMatch(Character::isDigit);
        //then
        assertThat(result).isFalse();
    }
}
