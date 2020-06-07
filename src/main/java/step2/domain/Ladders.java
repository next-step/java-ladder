package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private List<Ladder> ladderList = new ArrayList<>();

    public Ladders() {

    }

    public Ladders(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }


    public List<Ladder> getLadderList() {
        return ladderList;
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

}
