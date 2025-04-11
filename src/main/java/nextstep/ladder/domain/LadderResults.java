package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResults {
    private final Map<ParticipantName, String> results;

    public LadderResults(Map<ParticipantName, String> results) {
        this.results = results;
    }

    public String getByName(String name) {
        return results.get(new ParticipantName(name));
    }

    public List<LadderResult> getAll() {
        return results.entrySet().stream()
                .map(e -> new LadderResult(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

}
