package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> Lines = new ArrayList <>();

    public Ladder(int userCount, int ladderHeight){
        for(int i=0; i<ladderHeight; i++){
            Lines.add(createLine(userCount));
        }
    }

    public Line createLine(int userCount){
        return new Line(userCount);
    }

}
