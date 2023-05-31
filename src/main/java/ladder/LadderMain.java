package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        ParticipantNames participantNames = new ParticipantNames(inputView.requestParticipants());
        ExecutionResults executionResults = new ExecutionResults(inputView.requestExecutionResults(), participantNames.getParticipantsSize());
        int maximumLadderHeight = inputView.requestMaximumLadderHeight();

        List<Boolean> initializedPoints = Line.initializePoints(participantNames.getParticipantsSize(), RandomMakePointsStrategy.getInstance());
        Ladder ladder = new Ladder(initializedPoints, maximumLadderHeight); // 사다리 생성

        LadderGame ladderGame = new LadderGame(ladder, participantNames, executionResults); // 사다리 게임 실행

        resultView.showLadderResult(ladderGame); // 사다리 결과

        resultView.showExecutionResult(ladderGame); // 실행 결과
    }
}
