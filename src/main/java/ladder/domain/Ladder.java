package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    private List<String> results = new ArrayList<>();

    public Ladder(List<Line> lines, List<String> results) {
        this.lines = lines;
        this.results = results;
    }

    public static Ladder of(int countOfPerson, String[] results, int countOfLadder) {
        if (countOfPerson != results.length) {
            throw new IllegalArgumentException("참가자와 결과의 수는 동일해야합니다.");
        }
        List<Line> newLadder = new ArrayList<>();
        for (int i = 0; i < countOfLadder; i++) {
            newLadder.add(new Line(countOfPerson));
        }

        return new Ladder(newLadder, List.of(results));
    }

    public int size() {
        return this.lines.size();
    }

    public Line getLine(int index) {
        return this.lines.get(index);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
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
