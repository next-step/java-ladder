package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    
    private static final Lines lines = new Lines(List.of(LineTest.line1, LineTest.line2, LineTest.line2));
    
    @Test
    @DisplayName("다음 인덱스")
    void nextIndex() {
        // given, when
        int nextIndex = lines.nextIndex(PlayerTest.player);

        // then
        assertThat(nextIndex).isEqualTo(1);
    }

}
