package nextstep.ladder.view.dto;

import nextstep.ladder.model.ParticipantResult;

import java.util.List;
import java.util.stream.Collectors;

public final class ParticipantResultResponse {

    private final String participant;
    private final String result;

    public ParticipantResultResponse(String participant, String result) {
        this.participant = participant;
        this.result = result;
    }

    private static ParticipantResultResponse from(ParticipantResult participantResult) {
        return new ParticipantResultResponse(participantResult.participant().value(), participantResult.result().value());
    }

    public static List<ParticipantResultResponse> listFrom(List<ParticipantResult> participantResults) {
        return participantResults.stream()
                .map(ParticipantResultResponse::from)
                .collect(Collectors.toList());
    }

    public String getParticipant() {
        return participant;
    }

    public String getResult() {
        return result;
    }
}
