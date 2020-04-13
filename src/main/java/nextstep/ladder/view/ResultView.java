package nextstep.ladder.view;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeSheet;
import nextstep.ladder.domain.model.Position;
import nextstep.ladder.domain.model.Prize;

public class ResultView {

  private static final String LADDER_RESULT = "사다리 결과";
  private static final String PLAYER_AND_PRIZE_FORMAT = "%6s";
  private static final String LADDER_WITH_LEG = "|-----";
  private static final String LADDER_WITHOUT_LEG = "|     ";

  public void printLadderResult(LadderGame ladderGame, Players players) {
    printWithNewLine(LADDER_RESULT);
    printNames(players);
    printLadder(ladderGame.getLadder());
  }

  public void printPrizes(List<String> prizes) {
    System.out.println();
    prizes.forEach(prize -> System.out.printf(PLAYER_AND_PRIZE_FORMAT, prize));
  }

  private void printNames(Players players) {
    players.getPlayers()
        .forEach(player -> System.out.printf(PLAYER_AND_PRIZE_FORMAT, player.getName()));
  }

  private void printLadder(Ladder ladder) {
    ladder.getLadderLines()
        .forEach(this::printLadderLine);
  }

  private void printLadderLine(LadderLine ladderLine) {
    int width = ladderLine.getWidth();

    System.out.println();
    IntStream.range(0, width)
        .mapToObj(Position::at)
        .forEach(position -> {
           Position moved = ladderLine.move(position);
           String ladderPiece = moved.left() == position ? LADDER_WITH_LEG : LADDER_WITHOUT_LEG;

           System.out.print(ladderPiece);
        });
  }

  private void printWithNewLine(String sentence) {
    System.out.println();
    System.out.println(sentence);
  }
}
