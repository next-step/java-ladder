package step2.controller;

import step2.domain.*;
import step2.dto.RequestLadderDTO;
import step2.dto.ResponseLadderDTO;
import step2.dto.ResponseMembersDTO;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderGameController {
    public void run() {
        RequestLadderDTO requestLadderDTO = exportRequestLadderDTO();

        Members members = requestLadderDTO.getMembers();
        Ladder ladder = Ladder.of(members.getSize(), requestLadderDTO.getLadderHeight(), new RandomGenerator());

        ResponseMembersDTO responseMembersDTO = exportResponseMembersDTO(members);
        ResultView.printMembers(responseMembersDTO);

        printLadder(ladder);

        Member member = new Member(InputView.inputMatchMemberName());
        Match match = new Match(member, members, ladder);
        match.getMatchOfAll(exportRequestLadderDTO().getResults());
    }

    private RequestLadderDTO exportRequestLadderDTO() {
        Members members = Members.of(InputView.inputLadderGameMember());
        Results results = Results.of(InputView.inputLadderGameResult());
        int ladderHeight = InputView.inputLadderHeight();

        return new RequestLadderDTO(members, ladderHeight, results);
    }

    private ResponseMembersDTO exportResponseMembersDTO(Members members) {
        return new ResponseMembersDTO(members.getNames());
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line line) {
        for (Point point : line.getLine()) {
            ResponseLadderDTO responseLadderDTO = new ResponseLadderDTO(point.hasLine());
            ResultView.printLadder(responseLadderDTO);
        }
        ResultView.printEnter();
    }
}
