package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.drawPolicy.DrawablePolicy;

public class Ladder {

    private List<LadderRow> ladderRows;

    public Ladder(List<LadderRow> ladderRows) {
        this.ladderRows = ladderRows;
    }

    public Ladder(Persons persons, Height height, DrawablePolicy drawablePolicy){
        ladderRows = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            LadderRow ladderRow = new LadderRow(persons.personListSize(), drawablePolicy);
            ladderRows.add(ladderRow);
        }
    }

    public List<LadderRow> getLadder() {
        return ladderRows;
    }

    public int getResultIndex(int index){
        int currentIndex = index;
        for(LadderRow ladderRow : ladderRows){
            currentIndex = ladderRow.movedPointIndex(currentIndex);
        }
        return currentIndex;
    }
}
