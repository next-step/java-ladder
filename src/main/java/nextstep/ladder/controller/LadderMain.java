package nextstep.ladder.controller;

import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Players;
import nextstep.ladder.view.InView;
import nextstep.ladder.view.OutView;

public class LadderMain {
    public static void main(String[] args) {
        Players players = new Players(askPlayersName(), askGamePrize());
        Ladder ladder = Ladder.init(askLadderHeight(), players.countOfPlayer());

        GameResult gameResult = new GameResult(players, ladder);

        printGameResult(ladder, players);
        while (showPlayerResult(gameResult)) ;
    }

    private static String askPlayersName() {
        OutView.askPlayersName();
        return InView.getString();
    }

    private static String askGamePrize() {
        OutView.setAskGameResult();
        return InView.getString();
    }

    private static int askLadderHeight() {
        OutView.askLadderHeight();
        return InView.getInt();
    }

    private static void printGameResult(Ladder ladder, Players players) {
        OutView.printLadder();
        OutView.println(players.getFormattedName());
        OutView.println(ladder.getFormattedLine());
        OutView.println(players.getFormattedPrize());
    }

    private static boolean showPlayerResult(GameResult gameResult) {
        OutView.askWhoesResult();
        String playerName = InView.getString();

        if (playerName.toLowerCase().equals("all")) {
            OutView.printResult(gameResult.getFormattedResult());
            return false;
        }

        OutView.printResult(gameResult.getPrize(playerName));
        return true;
    }
}
