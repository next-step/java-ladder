package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Lines implements Iterable<Line> {
    private List<Line> lineList;

    public Lines(List<Line> lineList) {
        this.lineList = lineList;
    }

    public int calulateGameResult(int startPosition){
        int resultPosition = startPosition;
        for(Line line : this){
            resultPosition = line.findRoute(resultPosition);
        }
        return resultPosition;
    }

    @Override
    public Iterator<Line> iterator() {
        return lineList.iterator();
    }
}
