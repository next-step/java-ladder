package ladder.controller.dto;

import java.util.List;

public class LadderGenerationResponse {

    private final List<String> participantNameList;
    private final int ladderWidth;
    private final List<LadderLine> ladderLineList;

    public LadderGenerationResponse(List<String> participantNameList, int ladderWidth, List<LadderLine> ladderLineList) {
        this.participantNameList = participantNameList;
        this.ladderWidth = ladderWidth;
        this.ladderLineList = ladderLineList;
    }

    public List<String> getParticipantNameList() {
        return participantNameList;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public List<LadderLine> getLadderLineList() {
        return ladderLineList;
    }
}
