package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int countOfLadder) {
        List<Line> newLadder = new ArrayList<>();
        for (int i = 0; i < countOfLadder; i++) {
            newLadder.add(new Line(countOfPerson));
        }

        return new Ladder(newLadder);
    }

    public int size() {
        return this.lines.size();
    }

    public Line getLine(int index) {
        return this.lines.get(index);
    }

    private int getLadderIndex(int index) {
        for (int i = 0; i < lines.size(); i++) {
            index += lines.get(i).move(index);
        }
        return index;
    }

    public LadderResult getLadderResult(Participants participants, Results results) {
        Map<String, String> ladderResult = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            ladderResult.put(participants.getParticipant(i).toString(), results.getResult(getLadderIndex(i)));
        }
        return new LadderResult(ladderResult);
    }
}
