package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("LadderSize, LadderLineGenerater를 받아 Ladder 인스튼스 생성")
    @Test
    void create() {
        assertThat(Ladder.create(new LadderSize(1), AutoLineGenerator.create())).isNotNull();
    }
}
