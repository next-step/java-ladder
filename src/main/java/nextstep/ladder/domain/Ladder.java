package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.utils.ObjectUtils;

public class Ladder {

    private final Names names;
    private final Lines lines;
    private final List<String> results;

    private Ladder(List<String> names, List<String> results, int height, ConnectPolicy connectPolicy) {
        validate(names);

        this.names = new Names(names);
        lines = new Lines(names.size(), height);
        lines.connectLinesWithPolicy(connectPolicy);

        this.results = results;
    }

    public static Ladder of(List<String> names, List<String> results, int ladderHeight, ConnectPolicy connectPolicy) {
        return new Ladder(names, results, ladderHeight, connectPolicy);
    }

    private void validate(List<String> names) {
        if (ObjectUtils.isEmpty(names)) {
            throw new IllegalArgumentException("이름이 없으면 사다리 못 만듦");
        }
    }

    public int lineHeight() {
        return lines.lineHeight();
    }

    public int lineCount() {
        return lines.lineCount();
    }

    public List<String> getLineNames() {
        return names.get();
    }

    @Override
    public String toString() {
        return "{" + lines + '}';
    }

    public Lines getLines() {
        return lines;
    }

    public List<String> getResults() {
        return results;
    }

    public String checkResultOf(String resultName) {
        int nameIndex = names.indexOf(resultName);

        int resultIndex = lines.resultIndexOf(
            convertIndexToLadderColumnIndex(nameIndex)
        );

        return results.get(
            convertLadderColumnIndexToIndex(resultIndex)
        );
    }

    private int convertIndexToLadderColumnIndex(int index) {
        return index * 2;
    }

    private int convertLadderColumnIndexToIndex(int index) {
        return index / 2;
    }

}

