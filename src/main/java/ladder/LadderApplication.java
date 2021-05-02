package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Record;
import ladder.domain.Result;
import ladder.rule.LineRule;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
  public static void main(String[] args) {
    Players players = Players.create(InputView.getPlayerNames());
    Result result = Result.generate(InputView.getResult());

    int width = players.totalSize() - 1;
    int height = InputView.getHeight();

    Ladder ladder = Ladder.generate(height, width, LineRule.random());
    Record record = Record.generate(players, ladder);

    ResultView.print(players, ladder, result);

    boolean isFindAll;
    do {
      String keyword = InputView.getResultByKeyword();
      isFindAll = isFindAll(keyword);
      ResultView.printResultByKeyword(players, record, result, keyword, isFindAll);
    } while (!isFindAll);
  }

  private static boolean isFindAll(String keyword) {
    return keyword.equals(InputView.FIND_ALL_KEYWORD);
  }
}
