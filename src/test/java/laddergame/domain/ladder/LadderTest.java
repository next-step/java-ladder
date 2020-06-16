package laddergame.domain.ladder;

import laddergame.domain.vo.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
    @DisplayName("사다리 높이와 참여 인원수에 맞는 사다리를 만든다.")
    @ParameterizedTest
    @CsvSource({"1, 2", "2, 4"})
    void createLadder(int ladderHeight, int numberOfPlayer) {
        Ladder ladder = new Ladder(new Height(ladderHeight), numberOfPlayer, () -> true);

        List<Line> lines = ladder.getLines();
        List<Bridge> bridges = lines.get(0).getBridges();

        assertAll(
                () -> assertThat(lines.size()).isEqualTo(ladderHeight),
                () -> assertThat(bridges.size()).isEqualTo(numberOfPlayer - 1)
        );
    }
}