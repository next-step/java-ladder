package step4_ladderGame.controller;

import step4_ladderGame.domain.LadderGame;
import step4_ladderGame.domain.MatchOfPrize;
import step4_ladderGame.domain.Players;
import step4_ladderGame.dto.MatchOfPrizeDto;
import step4_ladderGame.view.InputView;
import step4_ladderGame.view.OutputView;

public class LadderController {

    private final LadderGame ladderGame;
    private final MatchOfPrize matchOfPrize;

    private static final String DELIMITER = ",";
    private static final String ALL = "all";


    public LadderController(String playerName, int ladderHeight, String prizes) {
        String[] playerNames = parse(playerName);
        this.ladderGame = LadderGame.of(playerNames, ladderHeight);
        this.matchOfPrize = MatchOfPrize.of(parse(prizes), playerNames.length);
    }

    private String[] parse(String names) {
        return names.split(DELIMITER);
    }

    public void viewLadder() {
        OutputView.print(ladderGame.playersDto(), ladderGame.ladderDto(), matchOfPrize.prizesDto());
    }

    private void play() {
        Players players = ladderGame.play();
        matchOfPrize.match(players);
    }

    public MatchOfPrizeDto returnMatchResult(String message) {
        if (message.equals(ALL)) {
            return matchOfPrize.all();
        }
        return matchOfPrize.getPrizeResult(message);
    }

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(InputView.playerName(), InputView.ladderHeight(), InputView.prize());
        ladderController.viewLadder();
        ladderController.play();
        String message;
        do {
            message = InputView.prizeOfPlayer();
            OutputView.printMatchPrize(ladderController.returnMatchResult(message));
        } while (!message.equals(ALL));
    }


}
