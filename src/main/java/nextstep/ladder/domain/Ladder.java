package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.utils.ObjectUtils;

public class Ladder {

    private final LadderLines ladderLines;
    private final List<String> results;

    private Ladder(List<String> names, List<String> results, int height) {
        validate(names, results);
        this.ladderLines = new LadderLines(names, height);
        this.results = results;
    }

    public static Ladder of(List<String> names, List<String> results, int ladderHeight) {
        return new Ladder(names, results, ladderHeight);
    }

    private void validate(List<String> names, List<String> results) {
        if (ObjectUtils.isEmpty(names)) {
            throw new IllegalArgumentException("이름이 없으면 사다리 못 만듦");
        }

        if (names.size() != results.size()) {
            throw new IllegalArgumentException("참가자 이름 수와 결과 수는 같게 입력되어야함.");
        }
    }

    public List<String> getLineNames() {
        return ladderLines.getNames();
    }

    @Override
    public String toString() {
        return "{" + ladderLines + '}';
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines.get();
    }

    public List<String> getResults() {
        return results;
    }

    public String checkResultOf(String resultName) {
        return results.get(
            ladderLines.checkResultOf(resultName)
        );
    }

}

