package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Lines;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.Input;
import ladder.view.Output;

public class ladderApp {
    public static void main(String[] args) {
        Players players = Input.scanPlayers();
        Height height = new Height(Input.scanNumber());

        Output.printPlayers(players.players());

        Lines lines = Lines.create(players.size(), height.height());
        Output.printLines(lines.lines());
    }
}
