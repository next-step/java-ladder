package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderRunner {
    private final List<Name> names;
    private final Ladder ladder;

    public LadderRunner(List<Name> names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public Map<Name, String> run(int height, List<String> results) {
        validate(results);

        Map<Name, String> ladderRunResult = new HashMap<>();
        for (int currentLine = 0; currentLine < names.size(); currentLine++) {
            Name name = names.get(currentLine);
            ladderRunResult.put(name, results.get(getPersonResult(currentLine, height)));
        }

        return ladderRunResult;
    }

    private void validate(List<String> results) {
        if (names.size() != results.size() || ladder.getLineSize() != results.size()) {
            throw new IllegalArgumentException("결과와 인원 수가 다릅니다");
        }
    }

    private int getPersonResult(int currentLine, int height) {
        for (int currentPosition = 0; currentPosition < height; currentPosition++) {
            Point currentPoint = ladder.getLine(currentLine).getPoint(currentPosition);
            currentLine += currentPoint.getMovingValue();
        }
        return currentLine;
    }
}
