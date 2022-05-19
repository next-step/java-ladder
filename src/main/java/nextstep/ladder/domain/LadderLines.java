package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLines {

    private final Names names;
    private List<LadderLine> ladderLines = new ArrayList<>();

    public LadderLines(List<String> names, int height) {
        this.names = new Names(names);

        for (int i = 0; i < height; ++i) {
            ladderLines.add(LadderLine.init(names.size()));
        }
    }

    public int lineHeight() {
        return ladderLines.size();
    }

    public int lineCount() {
        return names.size();
    }

    public List<String> getNames() {
        return names.get();
    }

    @Override
    public String toString() {
        return "{" + names +
            ", " + ladderLines +
            "}\n";
    }

    public int checkResultOf(String name) {
        int pointIndex = names.indexOf(new Name(name));

        for (LadderLine ladderLine : ladderLines) {
            pointIndex = ladderLine.move(pointIndex);
        }

        return pointIndex;
    }

    public List<LadderLine> get() {
        return ladderLines;
    }

    protected void handlePointManually(int lineIndex, int pointIndex, Direction direction) {
        ladderLines.get(lineIndex).handlePoint(pointIndex, direction);
    }

}
