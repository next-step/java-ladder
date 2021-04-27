package step4;


import step4.controller.LadderController;
import step4.domain.*;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Players players = LadderController.getPlayers();
        Prizes prizes = LadderController.getPrizes(players.getSize());
        int height = LadderController.getHeight();
        Ladder ladder = LadderController.createLines(players.getSize(), height);

        LadderController.showResult(players, ladder, prizes);

        String playerName = LadderController.getPlayerName();
        Players playersByname = LadderController.getPlayersByname(players, playerName);
        Players EndPlayers = LadderController.getLadderResults(playersByname, ladder);
        Map<Player, String> award = LadderController.getAward(EndPlayers, prizes);

        LadderController.showAward(award);
    }
}
