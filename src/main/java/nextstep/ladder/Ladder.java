package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.drawPolicy.DrawablePolicy;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(List<LadderRow> ladderRows) {
        this.ladderRows = ladderRows;
    }

    public Ladder(Persons persons, Height height, DrawablePolicy drawablePolicy){
        ladderRows = new ArrayList<>();

        if (persons.personListSize() <= 0) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람은 0또는 음수가 될 수 없습니다");
        }

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
