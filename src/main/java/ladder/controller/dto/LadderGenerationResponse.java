package ladder.controller.dto;

import java.util.List;

public class LadderGenerationResponse {

    private final List<String> participants;

    public LadderGenerationResponse(List<String> participants) {
        this.participants = participants;
    }

    public List<String> getParticipants() {
        return participants;
    }
}
