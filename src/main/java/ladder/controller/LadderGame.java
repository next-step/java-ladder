package ladder.controller;

import ladder.domain.*;
import ladder.strategy.LineGenerateStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Random rd = new Random();

    public void start() {
        Participants participants = inputView.getParticipantNames();
        ExpectedResults expectedResults = inputView.getExpectedResults(participants.size());
        LadderHeight ladderHeight = inputView.getLadderHeight();
        Lines lines = Lines.from(ladderHeight.getHeight(), participants.size(), lineGenerateStrategy());

        resultView.printParticipants(participants);
        resultView.printLadder(lines);
        resultView.printExpectedResults(expectedResults);
        Results results = lines.getResult(participants, expectedResults);

        String desireParticipantName = inputView.getDesireParticipantName();
        Participants desireParticipants = participants.getDesireParticipants(desireParticipantName);
        Results desireResult = results.getDesireResults(desireParticipants);
        resultView.printResults(desireResult);
    }

    private LineGenerateStrategy lineGenerateStrategy() {
        return (size) -> {
            List<Boolean> points = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                points.add(getBooleanPoint(points, i));
            }
            return points;
        };
    }

    private boolean getBooleanPoint(List<Boolean> points, int index) {
        if (isFalsePoint(points, index)) {
            return false;
        }
        return rd.nextBoolean();
    }

    private boolean isFalsePoint(List<Boolean> points, int index) {
        return index == 0 || points.get(index - 1);
    }

}
