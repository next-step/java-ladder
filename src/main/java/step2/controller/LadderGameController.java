package step2.controller;

import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.Match;
import step2.domain.Member;
import step2.domain.Members;
import step2.domain.Point;
import step2.domain.RandomGenerator;
import step2.domain.Result;
import step2.domain.Results;
import step2.dto.RequestLadderDTO;
import step2.dto.ResponseLadderDTO;
import step2.dto.ResponseMatchDTO;
import step2.dto.ResponseMembersDTO;
import step2.dto.ResponseResultDTO;
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
        printResults(requestLadderDTO.getResults());

        Member findMember = new Member(InputView.inputMatchMemberName());
        Results results = requestLadderDTO.getResults();
        printResultMatchByMember(members, ladder, results, findMember);
    }

    private void printResultMatchByMember(Members members, Ladder ladder, Results results, Member findMember) {
        ResponseMatchDTO responseMatchDTO = new ResponseMatchDTO(Match.findOfResults(members, ladder, results, findMember));
        ResultView.printMatch(responseMatchDTO);
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

    private void printResults(Results results) {
        for (Result result : results.getResults()) {
            ResponseResultDTO responseResultDTO = new ResponseResultDTO(result);
            ResultView.printResult(responseResultDTO);
        }
        ResultView.printEnter();
    }
}
