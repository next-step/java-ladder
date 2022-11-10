package nextstep.ladder;

import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.dto.AskHeightOfLadderDto;
import nextstep.ladder.view.dto.AskParticipantNamesDto;

public class LadderGameApp {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        AskParticipantNamesDto askParticipantNamesDto = inputView.askParticipantNames();
        Names names = askParticipantNamesDto.getNames();

        AskHeightOfLadderDto askHeightOfLadderDto = inputView.askHeightOfLadder();
        int heightOfLadder = askHeightOfLadderDto.getHeight();
    }
}
