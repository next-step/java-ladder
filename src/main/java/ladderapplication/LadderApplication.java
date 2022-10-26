package ladderapplication;

import ladderapplication.models.Ladder;
import ladderapplication.models.Player;
import ladderapplication.models.requests.LadderRequest;
import ladderapplication.models.requests.PlayerRequest;
import ladderapplication.ui.Printer;

import java.util.List;
import java.util.stream.Collectors;

public class LadderApplication {

    public static void main(String[] args) {
        List<PlayerRequest> playerRequests = Printer.requestPlayer();
        LadderRequest ladderRequest = Printer.requestLadder();

        List<Player> players = playerRequests.stream().map(Player::from).collect(Collectors.toList());
        Ladder ladder = Ladder.of(ladderRequest, players);
        ladder.print();
    }

}
