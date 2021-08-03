package nextstep.ladder.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTypeTest {

    @DisplayName("입력값에 해당하는 사다리 타입을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"true:TRUE", "false:FALSE"}, delimiter = ':')
    void find_ladder_type(boolean creatable, LadderType type) {
        assertThat(LadderType.findByType(creatable)).isEqualTo(type);
    }
}