package laddarGame.domain;

import java.util.ArrayList;
import java.util.List;

//각 사다리 라인을 관리하는 일급컬렉션
public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int playerCount, int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(playerCount));
        }
        this.lines = lines;
    }
}
