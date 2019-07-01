package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder = new ArrayList <>();

    public Ladder(int userCount, int ladderHeight){
        for(int i=0; i<ladderHeight; i++){
            ladder.add(createLine(userCount));
        }
    }

    public List<Line> getLadder(){
        return this.ladder;
    }

    private Line createLine(int userCount){
        return new Line(userCount);
    }

}
