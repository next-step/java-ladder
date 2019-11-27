package reladder.controller;

import reladder.domain.*;
import reladder.service.LadderGame;
import reladder.service.LadderGameResult;

import java.util.Map;

public class LadderController {

    private static final String ERROR_MESSAGE = "매칭되는 값이 없습니다.";

    public MatchUp register(String names, String result) {
        return new MatchUp(names, result);
    }

    public LadderGame create(MatchUp matchUp, int height) {
        Ladder ladder = DefaultLadderGenerator.getInstance().generate(height, matchUp.getPeopleCount());
        return new LadderGame(ladder, matchUp);
    }

    public String result(LadderGame ladderGame, String personName) {
        try {
            LadderGameResult ladderGameResult = new LadderGameResult(ladderGame);
            return ladderGameResult.getResult(personName);
        } catch (RuntimeException e) {
            return e.getMessage() + " " + ERROR_MESSAGE;
        }
    }

    public Map<String, Object> allResult(LadderGame ladderGame) {
        LadderGameResult ladderGameResult = new LadderGameResult(ladderGame);
        return ladderGameResult.getResultAll();
    }
}
