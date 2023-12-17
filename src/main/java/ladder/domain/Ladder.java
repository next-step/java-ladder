package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private static final String RESULT_FORMAT = "%-6s";

    private List<Line> lines = new ArrayList<>();

    private List<String> results = new ArrayList<>();

    public Ladder(int countOfPerson, String[] results, int countOfLadder) {
        if (countOfPerson != results.length) {
            throw new IllegalArgumentException("참가자와 결과의 수는 동일해야합니다.");
        }
        this.results = List.of(results);
        for (int i = 0; i < countOfLadder; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public int size() {
        return this.lines.size();
    }

    public Line getLine(int index) {
        return this.lines.get(index);
    }

    public String getResultsData() {
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(String.format(RESULT_FORMAT, result));
        }
        return sb.toString();
    }

    private String getLadderResult(int index) {
        for (int i = 0; i < lines.size(); i++) {
            index += lines.get(i).move(index);
        }
        return results.get(index);
    }

    public LadderResult getLadderResult(Participants participants) {
        Map<String, String> ladderResult = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            ladderResult.put(participants.getParticipant(i).toString(), getLadderResult(i));
        }
        return new LadderResult(ladderResult);
    }
}
