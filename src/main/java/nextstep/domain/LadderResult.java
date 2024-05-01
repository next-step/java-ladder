package nextstep.domain;

import java.util.*;

public class LadderResult {
    Map<String, String> result = new LinkedHashMap<>();
    private static final Integer FIRST_LINE = 0;

    public LadderResult(List<Participant> participants, List<String> prize) {
        HashMap<String, String> result = new LinkedHashMap<>();
        participants.forEach(((participant) -> {
            result.put(participant.getName(0), prize.get(participant.getPosition()));
        }));
        this.result = result;
    }

    public String get(String name) {
        return this.result.get(name);
    }

    public Map<String, String> getPrizeMappingMap() {
        return this.result;
    }
}
