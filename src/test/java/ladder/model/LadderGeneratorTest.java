package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

    private final int heightOfLadder = 1;
    private final Participants participants = Participants.of(List.of("java", "lust"));

    @Test
    @DisplayName("랜덤 사다리 생성 전략으로 true를 반환해 연결된 사다리를 생성")
    void testLadderGenerator_generateLadder_randomLadderGeneratorStrategy_ShouldReturnConnectedLadder() {
        Ladder ladder = LadderGenerator.generateLadder(heightOfLadder, participants, () -> true);
        assertThat(ladder.getNthOfLadder(0).isConnectedToNextLadder(0)).isTrue();
    }

    @Test
    @DisplayName("랜덤 사다리 생성 전략으로 false를 반환해 연결된 사다리를 생성")
    void testLadderGenerator_generateLadder_randomLadderGeneratorStrategy_ShouldReturnNonConnectedLadder() {
        Ladder ladder = LadderGenerator.generateLadder(heightOfLadder, participants, () -> false);
        assertThat(ladder.getNthOfLadder(0).isConnectedToNextLadder(0)).isFalse();
    }
}
