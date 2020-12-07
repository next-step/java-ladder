package ladder;

import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private Ladder ladder;

    public LadderGame(String membersString, int height){
        this(Arrays.asList(membersString.split(",")), height);
    }

    public LadderGame(List<String> members, int height) {
        this.ladder = new DefaultLadder(members, height);
    }

    public LadderGameResult run(){
        return new LadderGameResult(ladder);
    }

}
