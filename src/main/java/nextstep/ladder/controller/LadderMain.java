package nextstep.ladder.controller;

import nextstep.ladder.model.*;
import nextstep.ladder.view.InView;
import nextstep.ladder.view.OutView;

public class LadderMain {
    public static void main(String[] args) {
        Players players = new Players(askPlayersName());
        GamePrize gamePrize = new GamePrize(askGameResult());
        Ladder ladder = new Ladder(askLadderHeight(), players.countOfPlayer());
        GameResult gameResult = new GameResult(ladder, players.countOfPlayer());
        Game game = new Game(players, gamePrize, gameResult);

        printGameResult(ladder, game);

        while (showPlayerResult(game)) ;
    }

    private static String askPlayersName() {
        OutView.askPlayersName();
        return InView.getString();
    }

    private static String askGameResult() {
        OutView.setAskGameResult();
        return InView.getString();
    }

    private static int askLadderHeight() {
        OutView.askLadderHeight();
        return InView.getInt();
    }

    private static void printGameResult(Ladder ladder, Game game) {
        OutView.printLadder();
        OutView.println(game.getFormattedPlayersName());
        OutView.println(ladder.getFormattedLine());
        OutView.println(game.getFormattedPrize());
    }

    private static boolean showPlayerResult(Game game) {
        OutView.askWhoesResult();
        String playerName = InView.getString();

        if (playerName.toLowerCase().equals("all")) {
            OutView.printResult(game.getFormattedResult());
            return false;
        }

        OutView.printResult(game.getPrize(playerName));
        return true;
    }
}
