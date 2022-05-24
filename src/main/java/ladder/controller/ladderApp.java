package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Lines;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.Input;

public class ladderApp {
    public static void main(String[] args) {
        String scannedNames = Input.scanName();
        Players players = Player.parse(scannedNames);
        players.draw();

        Height height = new Height(Input.scanNumber());
        Lines lines = height.lines(players.size());
        lines.draw();
    }
}
