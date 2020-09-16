package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<User> users = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    private Ladder(int countOfUsers, int ladderHeight) {

        for(int i = 0; i < ladderHeight ; i ++){
            lines.add(Line.of(countOfUsers));
        }
    }

    public static Ladder of(int countOfUsers, int ladderHeight){
        return new Ladder(countOfUsers, ladderHeight);
    }

    public List<Line> getLines(){
        return new ArrayList<>(lines);
    }
}
