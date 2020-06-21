package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        // 참가자 생성
        String nameOfPerson = InputView.enterNameOfPerson();
        Participants participants = Participants.valueOf(nameOfPerson);
        int countOfPerson = participants.size();

        // 결과 생성
        String enteredResults = InputView.enterResults();
        Results results = Results.valueOf(enteredResults, countOfPerson);

        // 사다리 생성
        int ladderHeight = InputView.enterLadderHeight();
        Ladder ladder = Ladder.valueOf(ladderHeight, countOfPerson);
        ResultView.printLadder(participants, ladder, results);

        // 사다리 게임 실행
        GameConsole gameConsole = GameConsole.valueOf(participants, ladder);
        GameResult gameResult = gameConsole.runLadder(results);
        ResultView.printResult(gameResult);
    }
}
