package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.dto.LadderGameRequest;
import ladder.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void create() {
        String[] names = new String[]{"pobi","honux","crong","jk","aa","ccc"};
        int height = 8;
        LadderGameRequest ladderGameRequest = new LadderGameRequest(names, height);
        LadderGame ladderGame = new LadderGame(ladderGameRequest);
        List<Line> lineList = ladderGame.ladderBoard();

        assertThat(lineList.size()).isEqualTo(height);
        assertThat(lineList.get(0)
                .getPointList()
                .size()).isEqualTo(names.length * 2 -1);
        ResultView.printLineList(lineList);
        assertThat(isOverlapping(lineList)).isFalse();
    }

    private boolean isOverlapping(List<Line> lineList) {
        for (Line line : lineList) {
            List<Boolean> points = line.getPointList();
            boolean lineIsConnectedBefore = false;
            for (int i = 1; i < points.size(); i+=2) {
                Boolean currentPointIsConnected = points.get(i);
                if(lineIsConnectedBefore && currentPointIsConnected) return true;
                lineIsConnectedBefore = currentPointIsConnected;
            }
        }
        return false;
    }
}
