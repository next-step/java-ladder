package ladder;

import ladder.domain.*;
import ladder.domain.lineGenerator.DefaultLineGenerator;
import ladder.domain.lineGenerator.PersentageLineGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        Players players = Players.of(InputView.inputTryLine("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"));
        Results results = Results.of(InputView.inputTryLine("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"));
        GameLevel gameLevel = GameLevel.of(InputView.inputTryLine("실행할 사다리의 난이도는?"));

        LadderGame ladderGame = new LadderGame(players, results);
        Ladder ladder = ladderGame.makeLadder(gameLevel.getLineHeight(), new PersentageLineGenerator(gameLevel.getDrawingRate()));

        ResultView.printLadderResult(players, ladder, results);
        
        LadderResult ladderResult = ladderGame.start(ladder);
        
        String who = InputView.inputTryLine("결과를 보고 싶은 사람은?");
        ResultView.printGameResult(ladderResult, who);
        
    }
}
