package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("사다리 정상 생성")
    @Test
    void name() {

        Ladder ladder = Ladder.of(heightOfLine, personNames);

        assertThat(ladder.getLines()).hasSize(personNames.size());
        assertThat(ladder.getHeightOfLine()).isEqualTo(heightOfLine);
    }
}
