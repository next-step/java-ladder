package nextstep.domain;

import java.util.*;

public class LadderResult {
    private final Map<Participant, Integer> participantPositionMap = new LinkedHashMap<>();
    private static final Integer FIRST_LINE = 0;

    public LadderResult(List<Participant> participants) {
        for (int i = 0; i < participants.size(); i += 1) {
            participantPositionMap.put(participants.get(i), i);
        }
    }

    public void move(Line line) {
        participantPositionMap.forEach((key, value) -> {
            participantPositionMap.put(key, move(line, value));
        });
    }

    private int move(Line line, Integer position) {
        if (Objects.equals(position, FIRST_LINE) && line.hasLine(FIRST_LINE)) {
            return position + 1;
        }

        if (!Objects.equals(position, FIRST_LINE) && line.hasLine(position - 1)) {
            return position - 1;
        }

        if (!line.isFinalPosition(position) && line.hasLine(position)) {
            return position + 1;
        }
        return position;
    }

    public Integer getPosition(Participant participant) {
        return participantPositionMap.get(participant);
    }

    public void moves(Lines lines) {
        List<Line> linesList = lines.getLineList();
        linesList.forEach(this::move);
    }


    public Map<String, String> mappingPrize(List<String> prize) {
        HashMap<String, String> result = new LinkedHashMap<>();
        participantPositionMap.forEach(((participant, position) -> {
            result.put(participant.getName(0), prize.get(position));
        }));
        return result;
    }
}
