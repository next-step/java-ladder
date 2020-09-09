package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @Test
    @DisplayName("사다리높이 일급컬렉션 테스트")
    void ladderHeightTest() {
        int height = 3;
        LadderHeight ladderHeight = LadderHeight.create(height);

        assertThat(ladderHeight.getLadderHeight()).isEqualTo(height);
    }
}
