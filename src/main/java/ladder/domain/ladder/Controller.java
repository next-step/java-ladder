package ladder.domain.ladder;

import ladder.UI.RequestDto;
import ladder.UI.ResponseDto;
import ladder.domain.user.Participants;

public class Controller {

    public static ResponseDto readyLadderGame(RequestDto requestDto) {
        Participants participants = new Participants(requestDto.getParticipantNames());
        LadderContext ladderContext = new LadderContext(requestDto.getLadderHeight(), participants.size());

        return new ResponseDto(participants, ladderContext, new InputLadderResult(requestDto.getInputLadderResult()));
    }

    public static LadderResult play(ResponseDto responseDto) {
        InputLadderResult inputLadderResult = responseDto.getInputLadderResult();
        Participants participants = responseDto.getParticipants();
        return responseDto.getLadderContext().play(inputLadderResult, participants);
    }
}
