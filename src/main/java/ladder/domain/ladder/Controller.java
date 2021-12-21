package ladder.domain.ladder;

import ladder.UI.ResponseDto;
import ladder.domain.ladder.InputLadderResult;
import ladder.domain.ladder.LadderContext;
import ladder.domain.ladder.LadderResult;
import ladder.domain.user.Participants;

public class Controller {

    public static ResponseDto readyLadderGame(String participantNames, String inputLadderResult, int ladderHeight) {
        Participants participants = new Participants(participantNames);
        LadderContext ladderContext = new LadderContext(ladderHeight, participants.size());

        return new ResponseDto(participants, ladderContext, new InputLadderResult(inputLadderResult));
    }

    public static LadderResult play(ResponseDto responseDto) {
        InputLadderResult inputLadderResult = responseDto.getInputLadderResult();
        Participants participants = responseDto.getParticipants();
        return responseDto.getLadderContext().play(inputLadderResult, participants);
    }
}
