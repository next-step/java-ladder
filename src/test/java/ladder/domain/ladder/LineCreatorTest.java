package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineCreatorTest {

    @Test
    @DisplayName("사다리 정상 생성 테스트")
    void LinesCreateTest() {
        int playerCount = 5;
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);

        Lines lines = LinesCreator.create(playerCount, ladderHeight);
        List<Line> lineList = lines.getLineList();

        assertThat(lineList.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 게임 실행시 정상 출력 테스트")
    void LinesCreatePositionTest() {
        int playerCount = 5;
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);

        Lines lines = LinesCreator.create(playerCount, ladderHeight);
        LadderResults ladderResults = lines.create();
        Position resultPosition = ladderResults.getResultPosition(1);
        assertThat(resultPosition.getValue()).isBetween(0, 5);
    }

}