package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
     List<Line> lineList;

    public Ladder() {
        this.lineList = new ArrayList<>();
    }

     public List<Line> values() {
         return lineList;
     }

     public void add(Line line) {
         lineList.add(line);
     }
}
