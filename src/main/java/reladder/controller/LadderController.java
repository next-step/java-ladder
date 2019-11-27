package reladder.controller;

import jdk.internal.util.xml.impl.Input;
import reladder.LadderRequest;
import reladder.domain.*;
import reladder.service.LadderGame;
import reladder.service.LadderGameResult;
import reladder.view.InputView;

import java.util.Map;

public class LadderController {

    private static final String ERROR_MESSAGE = "매칭되는 값이 없습니다.";

    private String requestName;
    private String requestResult;
    private int height;

    public LadderController() {
        this.requestName = InputView.inputName();
        this.requestResult = InputView.inputResult();
        this.height = InputView.inputLadderHeight();
    }

    public MatchUp register() {
        LadderRequest ladderRequest = new LadderRequest();
        return ladderRequest.requestMatchUp(requestName, requestResult);
    }

    public Ladder create() {
        LadderRequest ladderRequest = new LadderRequest();
        MatchUp matchUp = ladderRequest.requestMatchUp(requestName, requestResult);
        return ladderRequest.requestLadder(height, matchUp, DefaultLadderGenerator.getInstance());
    }

    public LadderGame execute() {
        LadderRequest ladderRequest = new LadderRequest();
        MatchUp matchUp = ladderRequest.requestMatchUp(requestName, requestResult);
        Ladder ladder = ladderRequest.requestLadder(height, matchUp, DefaultLadderGenerator.getInstance());
        return ladderRequest.requestLadderGame(ladder, matchUp);
    }

    public String result(String requestResultName) {
        try {
            LadderRequest ladderRequest = new LadderRequest();
            MatchUp matchUp = ladderRequest.requestMatchUp(requestName, requestResult);
            Ladder ladder = ladderRequest.requestLadder(height, matchUp, DefaultLadderGenerator.getInstance());
            LadderGame ladderGame = ladderRequest.requestLadderGame(ladder, matchUp);
            return ladderRequest.requestGameResult(ladderGame, requestResultName);
        } catch (RuntimeException e) {
            return e.getMessage() + " " + ERROR_MESSAGE;
        }
    }

    public Map<String, Object> resultAll() {
        LadderRequest ladderRequest = new LadderRequest();
        MatchUp matchUp = ladderRequest.requestMatchUp(requestName, requestResult);
        Ladder ladder = ladderRequest.requestLadder(height, matchUp, DefaultLadderGenerator.getInstance());
        LadderGame ladderGame = ladderRequest.requestLadderGame(ladder, matchUp);
        return ladderRequest.requestGameResultAll(ladderGame);
    }

}
