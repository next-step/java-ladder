package ladder.domain;

import ladder.controller.Ladder;
import ladder.view.Input;
import ladder.view.Output;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return this.players.size();
    }

    public List<Player> players() {
        return Collections.unmodifiableList(this.players);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return this.players.stream()
                .map(p -> p.name())
                .reduce((acc, cur) -> acc + ", " + cur)
                .orElseThrow(() -> new RuntimeException("unreachable."));
    }

    public Players findPlayer(String playerName) {
        return new Players(
                this.players
                        .stream()
                        .filter(p -> p.name().equals(playerName))
                        .collect(Collectors.toList())
        );
    }

    public void showResult(List<String> rewards, Lines lines) {
        Players targetPlayers = Input.scanPlayerToShow(this);
        List<LadderResult> ladderResults = targetPlayers.players()
                .stream()
                .map(player -> new LadderResult(player, rewards.get(new Ladder(lines, player.no()).plays().x())))
                .collect(Collectors.toList());
        Output.printLadderResults(ladderResults);
        if (targetPlayers.size() != this.players.size()) {
            this.showResult(rewards, lines);
        };
    }
}
