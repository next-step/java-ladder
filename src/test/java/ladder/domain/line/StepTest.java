package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StepTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("객체 생성")
    void construct(boolean value) throws Exception {
        //given
        Step actual = Step.valueOf(value);

        //when

        //then
        assertThat(actual).isEqualTo(Step.valueOf(value));

    }

}
