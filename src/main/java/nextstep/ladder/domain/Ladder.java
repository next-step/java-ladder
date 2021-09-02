package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Ladder {

    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int ladderHeight, int userCount){
        for(int i = 0; i < ladderHeight; i++ ){
            ladder.add(new Line(userCount, new RandomMakeStrategy()));
        }
    }

    public ArrayList<Line> getLadder(){
        return ladder;
    }


}
