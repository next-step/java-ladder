package ladder.controller;

import ladder.domain.Player;
import ladder.view.Input;

import java.util.List;

public class ladderApp {
    public static void main(String[] args) {
       String scanned = Input.scan("Put player names separated by ','.");
       List<Player> players = Player.parse(scanned);

    }
}
