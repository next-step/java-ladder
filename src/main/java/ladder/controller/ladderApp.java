package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.Input;
import ladder.view.Output;

import java.util.*;

public class ladderApp {
    public static void main(String[] args) {
        Players players = Input.scanPlayers();
        List<String> rewards = Input.scanRewards();
        Height height = new Height(Input.scanHeight());

        Output.printPlayers(players.players());

        Ladder ladder = new Ladder(height.value(), players.size() - 1);
        Output.printLadder(ladder);

//        Output.printLines(lines.lines());
//        Output.printRewards(rewards);
//
//        players.showResult(rewards, lines);
    }
}
