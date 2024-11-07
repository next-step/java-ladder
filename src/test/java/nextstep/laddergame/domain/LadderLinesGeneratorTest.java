package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLinesGeneratorTest {
    @DisplayName("사다리 라인들이 모든 층에 세팅되지 않았는지 확인한다.")
    @Test
    void isAllNonSet() {
        List<Boolean> given = Collections.nCopies(5, Boolean.FALSE);
        LadderLinesGenerator ladderLinesGenerator = (beforeLadder, maxHeight) -> new Lines();

        boolean actual = ladderLinesGenerator.isAllNonSet(given);

        assertThat(actual).isTrue();
    }
}
