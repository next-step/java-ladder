package nextstep.ladder2.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> ladderLine;

    public Line(LineMaker maker, int size) {
        this.ladderLine = maker.makeLine(size);
    }

    public List<Boolean> showLine(){
        return new ArrayList<>(ladderLine);
    }


}
