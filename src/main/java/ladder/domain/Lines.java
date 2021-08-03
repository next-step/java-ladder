package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Lines implements Iterable<Line> {

    private List<Line> lineList;

    public Lines(List<Line> lineList) {
        this.lineList = lineList;
    }

//    public boolean checkGoUser(int row,int position){
//        return this.line(row).isGoUser(position);
//    }

    private Line line(int row){
        return this.lineList.get(row);
    }

    @Override
    public Iterator<Line> iterator() {
        return lineList.iterator();
    }
}
