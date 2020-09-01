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

  private final ViewInput viewInput;

  public LadderGame() {
    Scanner scanner = new Scanner(System.in);
    viewInput = new ViewInput(scanner);
  }

  private Players responsePlayer() {
    return mapToPlayers(viewInput.requestPlayerNames());
  }

  public static Players mapToPlayers(List<String> playerNames) {
    return new Players(
            IntStream.range(0, playerNames.size())
                    .mapToObj(i -> new Player(playerNames.get(i), i))
                    .collect(Collectors.toList()));
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

  private void announce(Players players, Ladder ladder, List<Prize> prizes) {
    LadderAnalysis ladderAnalysis = new LadderAnalysis(ladder);

    Player play = responsePlayerOfWinners(players);
    if (players.isIndividual(play)) {
      announceIndividual(players, ladder, prizes, ladderAnalysis, play);
    }

    if (players.isAllPlayers(play)) {
      announceAllPlayers(players, prizes, ladderAnalysis);
    }
  }

  private void announceIndividual(Players players, Ladder ladder, List<Prize> prizes, LadderAnalysis ladderAnalysis, Player play) {
    if (players.existPlayer(play)) {
      Chessmen chessmen = play.asChessmen();
      ladderAnalysis.stat(chessmen);
      ViewInput.printIndividual(prizes.get(chessmen.getLocation()));
    }

    announce(players, ladder, prizes);
  }

  private void announceAllPlayers(Players players, List<Prize> prizes, LadderAnalysis ladderAnalysis) {
    List<Chessmen> chessPieces = players.chessmenAsList();
    chessPieces.forEach(chessmen -> ladderAnalysis.stat(chessmen));

    ViewInput.printFinal(chessPieces, prizes);
  }

  private Player responsePlayerOfWinners(Players players) {
    return players.nameToPlayer(viewInput.requestNameOfWinners());
  }

  public static void main(String[] args) {

    // 입력
    LadderGame ladderGame = new LadderGame();
    Players players = ladderGame.responsePlayer();
    int ladderHeight = ladderGame.responseLadderHeight();
    List<Prize> prizes = ladderGame.responsePrizes(players.size());

    // 사다리 데이터 생성
    Ladder ladder = LadderGenerator.generate(players.size(), ladderHeight);

    // 출력
    ViewOutput.printLadder(new LadderRenderer(players, ladder, prizes));

    // 발표
    ladderGame.announce(players, ladder, prizes);
  }
}
