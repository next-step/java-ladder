package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.ladder.ladderInfo.LineCount;
import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("Lines 이 정상적으로 생성되는지 확인하는 테스트")
    void LinesCreateTest() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        LineCount lineCount = ladderPlayers.getRequestLineCount();
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);

        List<Line> lineList = Stream
                    .generate(() -> Line.createLine(lineCount))
                    .limit(ladderHeight.getHeight())
                    .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        assertThat(lineList.size()).isEqualTo(5);
    }
}
