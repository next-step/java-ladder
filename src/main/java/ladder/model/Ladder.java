package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int countOfPerson, int length) {
        List<LadderLine> ladderLines = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            ladderLines.add(LadderLine.init(countOfPerson));
        }
        return new Ladder(ladderLines);
    }

    public static Ladder of(List<LadderLine> ladderLines) {
        return new Ladder(ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int size() {
        return ladderLines.size();
    }

    public int move(int position) {
        for(int i = 0; i < ladderLines.size(); i++) {
            position = ladderLines.get(i).move(position);
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}

