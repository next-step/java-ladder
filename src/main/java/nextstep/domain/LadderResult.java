package nextstep.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<String, String> result;

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

    public List<String> getPrize() {
        return result.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<String, String> getPrizeMappingMap() {
        return this.result;
    }
}
