package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Lines;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.Input;
import ladder.view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class ladderApp {
    public static void main(String[] args) {
        Players players = Input.scanPlayers();
        List<Reward> rewards = Input.scanRewards();
        Height height = new Height(Input.scanNumber());

        Output.printPlayers(players.players());

        Lines lines = Lines.create(players.size(), height.height());
        Output.printLines(lines.lines());

        Output.printRewards(rewards);

        while (true) {
            Players targetPlayers = Input.scanPlayerToShow(players);
            List<LadderResult> ladderResults = targetPlayers.players()
                    .stream()
                    .map(player -> new LadderResult(player, rewards.get(new Ladder(lines, player.no()).plays().x())))
                    .collect(Collectors.toList());
            Output.printLadderResults(ladderResults);
            if (targetPlayers.size() == players.size()) {
                break;
            }
        }
    }
}
