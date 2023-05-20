package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.line.HorizontalLadderLine;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.line.point.LadderPointDirection;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.player.Player;
import ladder.domain.result.LadderGamePlayerResult;
import ladder.domain.result.LadderGameResult;

public class ResultView {

  public void printPlayers(LadderGamePlayerInfo playerInfo) {
    final String playerView = playerInfo.getPlayers().stream()
        .map(Player::getPlayerName)
        .map(name -> String.format("%-5s", name))
        .collect(Collectors.joining(" "));

    System.out.println(playerView);
  }

  public void printLadders(Ladder ladder) {
    final String ladderView = ladder.getHorizontalLines().stream()
        .map(HorizontalLadderLine::getPoints)
        .map(this::pointsToStr)
        .collect(Collectors.joining("\n"));

    System.out.println(ladderView);
  }

  private String pointsToStr(List<LinePoint> points) {
    return points.stream()
        .map(this::pointToView)
        .collect(Collectors.joining());
  }

  private String pointToView(LinePoint point) {
    if (point.getPointDirection() == LadderPointDirection.RIGHT) {
      return String.format("%-6s", "|-----");
    }

    return String.format("%-6s", "|") ;
  }

  public void showAllRewordResult(LadderGameResult playResult) {
    System.out.println("실행 결과");
    String result = playResult.getPlayerResultMap().values().stream()
        .map(this::stringifyPlayerResult)
        .collect(Collectors.joining("\n"));

    System.out.println(result);
  }

  public void showRewordResult(LadderGameResult playResult, String resultUserName) {
    System.out.println("실행 결과");

    LadderGamePlayerResult playerResult = playResult.resultOfPlayer(resultUserName);
    if (playerResult == null) {
      System.out.println("해당 이름을 가진 유저는 게임 목록에 없습니다.");
      return;
    }

    System.out.println(stringifyPlayerResult(playerResult));
  }

  private String stringifyPlayerResult(LadderGamePlayerResult playResult) {
    return String.format("%-5s : %s", playResult.getPlayerName(), stringifyRewordView(playResult.getReword()));
  }

  private String stringifyRewordView(int reword) {
   if (reword == 0) {
     return "꽝";
   }
   return String.valueOf(reword);
  }
}
