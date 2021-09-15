package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {
    @Test
    @DisplayName("true를 반환한다.")
    void LottoNumbersGeneratorTest() {
        LadderGenerator ladderGenerator = () -> true;
        assertThat(ladderGenerator.randomGenerate()).isEqualTo(true);
    }
}