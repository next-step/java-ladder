package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Lines;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.Input;

public class ladderApp {
    public static void main(String[] args) {
        String scannedNames = Input.scan("Put player names separated by ','.");
        Players players = Player.parse(scannedNames);

        String scannedHeight = Input.scan("Put max height of ladders");
        Height height = Height.parse(scannedHeight);

        players.draw();

        Lines lines = height.lines(players.size());
        lines.draw();
    }
}
