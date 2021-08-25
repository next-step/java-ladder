package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StepTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("객체 생성")
    void construct(boolean value) {
        //given
        Step actual = Step.valueOf(value);

        //when

        //then
        assertThat(actual).isEqualTo(Step.valueOf(value));

    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,true,true",
            "true,false,false",
            "false,true,false",
            "false,false,false"
    })
    @DisplayName("연속 여부 검증")
    void is_consecutive_steps(boolean left, boolean right, boolean expected) {
        //given
        Step step = Step.valueOf(left);

        //when
        boolean actual = step.isConsecutiveSteps(Step.valueOf(right));

        //then
        assertThat(actual).isEqualTo(expected);

    }

}
