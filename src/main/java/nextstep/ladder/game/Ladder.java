package nextstep.ladder.game;

import nextstep.ladder.dto.Participant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public Map<Participant, Integer> getResult(List<Participant> participants) {
        Map<Participant, Integer> result = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.get(i);
            int resultPosition = getResult(i);

            result.put(participant, resultPosition);
        }

        return result;
    }

    private Integer getResult(int position) {
        int currentPosition = position;
        for (Row row : rows) {
            currentPosition = row.nextPosition(currentPosition);
        }
        return currentPosition;
    }
}
