package step2.controller;

import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.Members;
import step2.domain.Point;
import step2.dto.RequestLadderDTO;
import step2.dto.ResponseLadderDTO;
import step2.dto.ResponseMembersDTO;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderGameController {
    public void run() {
        RequestLadderDTO requestLadderDTO = exportRequestLadderDTO();

        Members members = requestLadderDTO.getMembers();
        Ladder ladder = Ladder.of(members.getSize(), requestLadderDTO.getLadderHeight());

        ResponseMembersDTO responseMembersDTO = exportResponseMembersDTO(members);
        ResultView.printMembers(responseMembersDTO);

        printLadder(ladder);
    }

    private RequestLadderDTO exportRequestLadderDTO() {
        Members members = Members.of(InputView.inputLadderGameMember());
        int ladderHeight = InputView.inputLadderHeight();
        return new RequestLadderDTO(members, ladderHeight);
    }

    private ResponseMembersDTO exportResponseMembersDTO(Members members) {
        return new ResponseMembersDTO(members.getNames());
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(this::printLine);
    }

    private void printLine(Line line) {
        for (Point point : line.getLine()) {
            ResponseLadderDTO responseLadderDTO = new ResponseLadderDTO(point.hasLine());
            ResultView.printLadder(responseLadderDTO);
        }
        ResultView.printEnter();
    }
}
