package ladder;

import ladder.domain.*;
import ladder.util.LadderGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderStart {

  public static void main(String[] args) {
    Players players = InputView.inputPlayers();
    LadderResults ladderResults = InputView.inputLadderResult(players);
    int height = InputView.inputHeight();

    Ladder ladder = LadderGenerator.generate(height, players);

    ResultView.view(players, ladder, ladderResults);

    Map<Player, LadderResult> results = ladder.result().gameResults(ladderResults);

    String resultName;
    while (!"all".equalsIgnoreCase(resultName = InputView.inputResultPlayer())) {
      ResultView.resultPlayer(resultName, results);
    }

    ResultView.resultAllPlayer(results);
    //결과를 보고 싶은 사람은?
    //실행결과 - 한명만 입력시 결과만 보여줌
    //all을 입력하면 모두 보여줌
    //이름 : 결과
  }

}
