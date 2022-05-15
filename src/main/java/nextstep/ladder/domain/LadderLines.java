package nextstep.ladder.domain;

import java.util.List;

public class LadderLines {

    private final Names names;
    private final Lines lines;

    public LadderLines(List<String> names, int height, ConnectPolicy connectPolicy) {
        this.names = new Names(names);
        lines = new Lines(names.size(), height);
        lines.connectLinesWithPolicy(connectPolicy);
    }


    public int lineHeight() {
        return lines.lineHeight();
    }

    public int lineCount() {
        return lines.lineCount();
    }

    public List<String> getNames() {
        return names.get();
    }

    @Override
    public String toString() {
        return "LadderLines{" +
            "names=" + names +
            ", lines=" + lines +
            '}';
    }

    public Lines getLines() {
        return lines;
    }

    public int checkResultOf(String name) {
        int nameIndex = names.indexOf(name);

        int resultIndex = lines.resultIndexOf(
            convertIndexToLadderColumnIndex(nameIndex)
        );

        return convertLadderColumnIndexToIndex(resultIndex);
    }

    private int convertIndexToLadderColumnIndex(int index) {
        return index * 2;
    }

    private int convertLadderColumnIndexToIndex(int index) {
        return index / 2;
    }
}
