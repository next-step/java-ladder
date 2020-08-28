package nextstep.ladder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.biz.Chessmen;
import nextstep.ladder.biz.LadderAnalysis;
import nextstep.ladder.biz.LadderGenerator;
import nextstep.ladder.biz.Ladder;
import nextstep.ladder.ui.LadderRenderer;
import nextstep.ladder.ui.ViewInput;
import nextstep.ladder.ui.ViewOutput;

public class LadderGame {
  private static final Player ALL_PLAYERS = new Player("all", -1);

  private final ViewInput viewInput;

  public LadderGame() {
    Scanner scanner = new Scanner(System.in);
    viewInput = new ViewInput(scanner);
  }

  private List<Player> responsePlayer() {
     return mapToPlayers(viewInput.requestPlayerNames());
  }

  public static List<Player> mapToPlayers(List<String> playerNames) {
    return IntStream.range(0, playerNames.size())
            .mapToObj(i -> new Player(playerNames.get(i), i))
            .collect(Collectors.toList());
  }
  private int responseLadderHeight() {
    return viewInput.requestLadderHeight();
  }

  private List<Prize> responsePrizes() {
    return mapToPrizes(viewInput.requestPrizes());
  }

  public static List<Prize> mapToPrizes(List<String> prizes) {
    return IntStream.range(0, prizes.size())
            .mapToObj(i -> new Prize(prizes.get(i), i))
            .collect(Collectors.toList());
  }

  private void announce(List<Player> players, Ladder ladder, List<Prize> prizes) {
    LadderAnalysis ladderAnalysis = new LadderAnalysis(ladder);

    Player play = responseNameOfWinners(players);

    if (play == ALL_PLAYERS) {
      players.stream()
              .map(Player::asChessmen)
              .forEach(chessmen -> {
                ladderAnalysis.stat(chessmen);
                System.out.println(chessmen + ": " + prizes.get(chessmen.getLocation()));
              });
      return;
    }

    Chessmen chessmen = play.asChessmen();
    ladderAnalysis.stat(chessmen);
    System.out.println("실행 결과");
    System.out.println(prizes.get(chessmen.getLocation()));

    announce(players, ladder, prizes);
  }

  private Player responseNameOfWinners(List<Player> players) {
    String playName = viewInput.requestNameOfWinners();
    return players.stream()
            .filter(player -> player.match(playName))
            .findFirst()
            .orElseGet(() -> playName.equals("all") ? ALL_PLAYERS : null);

  }

  public static void main(String[] args) {

    // 입력
    LadderGame ladderGame = new LadderGame();
    List<Player> players = ladderGame.responsePlayer();
    int ladderHeight = ladderGame.responseLadderHeight();
    List<Prize> prizes = ladderGame.responsePrizes();

    // 사다리 데이터 생성
    Ladder ladder = LadderGenerator.generate(players.size(), ladderHeight);

    // 출력
    ViewOutput.print(new LadderRenderer(players, ladder));

    // 발표
    ladderGame.announce(players, ladder, prizes);
  }
}
