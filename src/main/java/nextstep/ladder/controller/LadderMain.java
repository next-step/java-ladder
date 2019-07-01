package nextstep.ladder.controller;

import nextstep.ladder.model.GamePrize;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Players;
import nextstep.ladder.view.InView;
import nextstep.ladder.view.OutView;

public class LadderMain {
    public static void main(String[] args) {
        Players players = new Players(askPlayersName());
        GamePrize gamePrize = new GamePrize(askGameResult());
        Ladder ladder = new Ladder(askLadderHeight(), players.countOfPlayer());
        printGameResult(players, ladder, gamePrize);
        OutView.println(ladder.resultLadder());
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

    private static void printGameResult(Players players, Ladder ladder, GamePrize gamePrize) {
        OutView.printLadder();
        OutView.println(players.getFormattedName());
        OutView.println(ladder.getFormattedLine());
        OutView.println(gamePrize.getFormattedResult());
    }
}
