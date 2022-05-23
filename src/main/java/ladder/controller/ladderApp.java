package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Player;
import ladder.view.Input;

import java.util.List;

public class ladderApp {
    public static void main(String[] args) {
       String scannedNames = Input.scan("Put player names separated by ','.");
       List<Player> players = Player.parse(scannedNames);
       String scannedHeight = Input.scan("Put max height of ladders");
       Height height = Height.parse(scannedHeight);
    }
}
