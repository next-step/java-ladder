package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:41
 */
public class Ladder {

    private final List<LadderLine> ladder;
    private final int ladderHeight;

    public Ladder(int countOfPerson, int inputLadderHeight) {
        this.ladderHeight = inputLadderHeight;
        this.ladder = crateLadderLines(countOfPerson);
    }

    private List<LadderLine> crateLadderLines(int countOfPerson) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int height = 0; height < ladderHeight; height++) {
            ladderLines.add(LadderLine.init(countOfPerson));
        }
        return ladderLines;
    }

    public int play(int personIndex) {
        int index = personIndex;
        for (LadderLine line : ladder) {
            index = line.move(index);
        }

        return index;
    }

    public List<LadderLine> getLadderLines() {
        ladder.forEach(line -> {
            line.getPointOfLine();
        });
        return Collections.unmodifiableList(ladder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return ladderHeight == ladder1.ladderHeight &&
                Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder, ladderHeight);
    }
}
