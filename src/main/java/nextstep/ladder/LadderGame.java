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
  private static final Player NONE_PLAYER = new Player("nobody", -1);

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

  private List<Prize> responsePrizes(int countOfPrize) {
    return mapToPrizes(viewInput.requestPrizes(countOfPrize));
  }

  public static List<Prize> mapToPrizes(List<String> prizes) {
    return IntStream.range(0, prizes.size())
            .mapToObj(i -> new Prize(prizes.get(i), i))
            .collect(Collectors.toList());
  }

  private void announce(List<Player> players, Ladder ladder, List<Prize> prizes) {
    LadderAnalysis ladderAnalysis = new LadderAnalysis(ladder);

    Player play = responseNameOfWinners(players);
    if (isIndividual(play)) {
      announceIndividual(players, ladder, prizes, ladderAnalysis, play);
    }

    if (isAllPlayers(play)) {
      announceAllPlayers(players, prizes, ladderAnalysis);
    }
  }

  private boolean isIndividual(Player play) {
    return play != ALL_PLAYERS;
  }

  private void announceIndividual(List<Player> players, Ladder ladder, List<Prize> prizes, LadderAnalysis ladderAnalysis, Player play) {
    if (existPlayer(play)) {
      Chessmen chessmen = play.asChessmen();
      ladderAnalysis.stat(chessmen);
      ViewInput.printIndividual(prizes.get(chessmen.getLocation()));
    }

    announce(players, ladder, prizes);
  }

  private boolean existPlayer(Player play) {
    return play != NONE_PLAYER;
  }

  private boolean isAllPlayers(Player play) {
    return play == ALL_PLAYERS;
  }

  private void announceAllPlayers(List<Player> players, List<Prize> prizes, LadderAnalysis ladderAnalysis) {
    List<Chessmen> chessPieces = players.stream()
            .map(Player::asChessmen)
            .collect(Collectors.toList());
    chessPieces.forEach(chessmen -> ladderAnalysis.stat(chessmen));

    ViewInput.printFinal(chessPieces, prizes);
  }

  private Player responseNameOfWinners(List<Player> players) {
    String playName = viewInput.requestNameOfWinners();
    return players.stream()
            .filter(player -> player.match(playName))
            .findFirst()
            .orElseGet(() -> playName.equals("all") ? ALL_PLAYERS : NONE_PLAYER);

  }

  public static void main(String[] args) {

    // 입력
    LadderGame ladderGame = new LadderGame();
    List<Player> players = ladderGame.responsePlayer();
    int ladderHeight = ladderGame.responseLadderHeight();
    List<Prize> prizes = ladderGame.responsePrizes(players.size());

    // 사다리 데이터 생성
    Ladder ladder = LadderGenerator.generate(players.size(), ladderHeight);

    // 출력
    ViewOutput.printLadder(new LadderRenderer(players, ladder));

    // 발표
    ladderGame.announce(players, ladder, prizes);
  }
}
