package step2;

import step2.controller.LadderController;
import step2.domain.*;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Players players = LadderController.getPlayers();
        Prizes prizes = LadderController.getPrizes(players.getSize());
        int height = LadderController.getHeight();
        Lines lines = LadderController.createLines(players.getSize(), height);

        LadderController.showResult(players, lines, prizes);

        String playerName = LadderController.getPlayerName();
        Players playersByname = LadderController.getPlayersByname(players, playerName);
        Players EndPlayers = LadderController.getLadderResults(playersByname, lines);
        Map<Player, String> award = LadderController.getAward(EndPlayers, prizes);

        LadderController.showAward(award);
    }
}
