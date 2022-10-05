package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static final Ladder LADDER = new Ladder(Arrays.asList(LineTest.LINE, LineTest.LINE, LineTest.LINE, LineTest.LINE, LineTest.LINE));
    
    @Test
    @DisplayName("사다리 생성")
    void create() {
        assertThat(LadderTest.LADDER).isNotNull();
    }
    
    @Test
    @DisplayName("LadderDTO 생성")
    void ladder_dto() {
        assertThat(LadderTest.LADDER.ladderInformation()).isNotNull();
    }
}
