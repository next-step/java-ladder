package ladder.controller.dto;

import java.util.List;

public class LadderGenerationResponse {

    private final List<String> participants;
    private final int ladderWidth;

    public LadderGenerationResponse(List<String> participants, int ladderWidth) {
        this.participants = participants;
        this.ladderWidth = ladderWidth;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }
}
