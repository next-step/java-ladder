package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RungTest {

    @DisplayName("Rung은 사다리의 발판이 존재하는지 여부를 가진다.")
    @ParameterizedTest
    @CsvSource(value = {"EXIST,true", "EMPTY,false"})
    void constructor(Rung rung, boolean exist) {
        assertThat(rung.exist())
                .isEqualTo(exist);
    }
}
