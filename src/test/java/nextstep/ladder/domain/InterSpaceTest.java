package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InterSpaceTest {

    @ParameterizedTest
    @CsvSource(value = {"true,true", "false,false"})
    @DisplayName("사다리 사이공간에 가로라인을 그리거나, 공백으로 지정할수 있다.")
    void interSpaceCrossLine(boolean hasCrossLine, boolean expectedLine) {
        InterSpace interSpace = new InterSpace(hasCrossLine);
        assertThat(interSpace.hasCrossLine()).isEqualTo(expectedLine);
    }
}