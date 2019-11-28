package reladder.controller;

import reladder.LadderRequest;
import reladder.LadderResponse;
import reladder.domain.*;
import reladder.service.LadderGame;
import reladder.service.LadderGameResult;

public class LadderController {

    private static final String ERROR_MESSAGE = "매칭되는 값이 없습니다.";

    private LadderGenerator ladderGenerator;
    public LadderController(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public LadderResponse execute(LadderRequest request) {
        MatchUp matchUp = new MatchUp(request.getInputName(), request.getInputResult());
        Ladder ladder = ladderGenerator.generate(request.getHeight(), matchUp.getPeopleCount());
        return new LadderResponse(new LadderGame(ladder, matchUp));
    }

    public LadderResponse result(LadderRequest request, String name) {
        try {
            MatchUp matchUp = new MatchUp(request.getInputName(), request.getInputResult());
            Ladder ladder = ladderGenerator.generate(request.getHeight(), matchUp.getPeopleCount());
            LadderGame ladderGame = new LadderGame(ladder, matchUp);
            return new LadderResponse(new LadderGameResult(ladderGame).getResult(name));
        } catch (RuntimeException e) {
            return new LadderResponse(e.getMessage() + " " + ERROR_MESSAGE);
        }
    }

    public LadderResponse resultAll(LadderRequest request) {
        MatchUp matchUp = new MatchUp(request.getInputName(), request.getInputResult());
        Ladder ladder = ladderGenerator.generate(request.getHeight(), matchUp.getPeopleCount());
        LadderGame ladderGame = new LadderGame(ladder, matchUp);
        return new LadderResponse(new LadderGameResult(ladderGame).getResultAll());
    }
}
