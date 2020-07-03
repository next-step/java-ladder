package ladder.domain;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<String, String> ladderResult;

    public LadderResult(Map<String, String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getLadderResultBy(final String attendees) {
        return ("all".equalsIgnoreCase(attendees)) ? getAllLadderResult() : getAttendeesResult(attendees);
    }

    private String getAllLadderResult() {
        return ladderResult.entrySet().stream()
                .map((entry) -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }

    private String getAttendeesResult(final String attendees) {
        if (!ladderResult.containsKey(attendees)) {
            throw new IllegalArgumentException();
        }
        return ladderResult.get(attendees);
    }

}
