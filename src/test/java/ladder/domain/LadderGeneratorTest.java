package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    Players players;
    Integer playersCount;

    @BeforeEach
    void setup() {
        this.players = new Players("moon, jae, heon, keep, going");
        this.playersCount = 5;
    }

    @Test
    @DisplayName("입력한 값 만큼 사다리 라인 생성")
    void generateLineTest() {
        Line line = LadderGenerator.generateLine(players);
        assertThat(line.size()).isEqualTo(playersCount - 1);
    }

    @Test
    @DisplayName("생성된 사다리 라인 겹침 테스트 ")
    void lineOverlapTest() {
        Line line = LadderGenerator.generateLine(players);
        for (int i = 1; i < playersCount - 1; i++) {
            assertThat(line.isLine(i - 1) && line.isLine(i)).isFalse();
        }
    }

    @Test
    @DisplayName("입력한 값(Height/Players)으로 사다리 생성 ")
    void ladderGeneratorTest() {
        int height = 5;
        Ladder ladder = LadderGenerator.generateLadder(height, players);

        assertThat(ladder.height()).isEqualTo(height);
        assertThat(ladder.getLadder().get(0)).isEqualTo(players.size() - 1);
    }

}
