package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList;

    public Ladder(List<Line> list) {
        lineList = list;
    }

    public static Ladder createLadder(int width, int ladderHeight) {
        List<Line> lineList = createLines(width, ladderHeight);

        return new Ladder(lineList);
    }

    private static List<Line> createLines(int width, int ladderHeight) {
        List<Line> tmpList = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            tmpList.add(new Line(width));
        }
        return tmpList;
    }

    // 오른쪽 아래로 이동
    public Boolean rightDown(int ladderPosition) {
        Line line = lineList.get(ladderPosition + 1);
        return line.getSpotList().get(ladderPosition + 1);
    }

    // 아래로 이동
    public Boolean Down(int ladderPosition) {
        Line line = lineList.get(ladderPosition + 1);
        return line.getSpotList().get(ladderPosition);
    }

    // 왼쪽 아래로 이동
    public Boolean leftDown(int ladderPosition) {
        Line line = lineList.get(ladderPosition + 1);
        return line.getSpotList().get(ladderPosition - 1);
    }

    public List<Line> getLines() {
        return lineList;
    }


}
