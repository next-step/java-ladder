package step2.dto;

import step2.domain.Match;

import java.util.Map;

public class ResponseMatchDTO {
    private final Match match;

    public ResponseMatchDTO(Match match) {
        this.match = match;
    }

    public Map<String, String> getMatch() {
        return match.getMatch();
    }
}
