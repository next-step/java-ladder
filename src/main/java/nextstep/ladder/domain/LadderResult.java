package nextstep.ladder.domain;

import nextstep.Pair;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<ParticipantName, String> results;

    public LadderResult(Map<ParticipantName, String> results) {
        this.results = results;
    }

    public String getByName(String name) {
        return results.get(new ParticipantName(name));
    }

    public List<Pair<ParticipantName, String>> getAll() {
        return results.entrySet().stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

}
