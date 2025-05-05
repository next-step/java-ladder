package nextstep.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<Participant, Bonus> result;

    public LadderResult(Map<Participant, Bonus> result) {
        this.result = result;
    }

    public String getBonusName(Participant participant) {
        return Optional.ofNullable(result.get(participant))
            .map(Bonus::getName)
            .orElseThrow(IllegalArgumentException::new);
    }

    public String findBonusByParticipantName(String name) {
        return Optional.ofNullable(getAllResult().get(name))
            .orElseThrow(IllegalArgumentException::new);
    }

    /* 헬퍼 메서드 */
    public Map<String, String> getAllResult() {
        return Collections.unmodifiableMap(
            result.entrySet().stream()
                .collect(Collectors.toMap(
                    e -> e.getKey().getName(),
                    e -> e.getValue().getName(),
                    (a, b) -> a, LinkedHashMap::new
                ))
        );
    }
}
