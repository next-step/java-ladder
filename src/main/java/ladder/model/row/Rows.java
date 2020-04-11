package ladder.model.row;

import ladder.model.player.Player;
import ladder.model.player.PlayerName;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.prize.PrizeName;
import ladder.model.result.GameResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rows {
    private List<Row> rows;

    public Rows(List<Row> rows) {
        this.rows = Collections.unmodifiableList(rows);
    }

    public static Rows create(Players players, Height height) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(it -> Row.create(players.getPlayerCount()))
                .collect(collectingAndThen(toList(), Rows::new));
    }

    public List<Row> getRows() {
        return rows;
    }

    public int getSize() {
        return rows.size();
    }

    public Row getRowsElement(int index) {
        return rows.get(index);
    }

    public GameResult getResult(Players players, LadderPrizes ladderPrizes) {
        Map<PlayerName, PrizeName> result = new HashMap<>();

        for (int i = 0; i < players.getPlayerCount(); i++) {
            int position = i;
            result.put(getPlayerNameAtFinalPosition(players, Position.of(i)), ladderPrizes.getPrizeNameAtIndex(i));
        }
        return new GameResult(result);
    }

    private PlayerName getPlayerNameAtFinalPosition(Players players, Position finalPosition) {
        return players.getPlayers().stream()
                .filter(player1 -> getFinalPosition(players, player1).equals(finalPosition))
                .findFirst()
                .map(Player::getName)
                .orElseThrow(IllegalAccessError::new);
    }

    private Position getFinalPosition(Players players, Player player) {
        return findFinalPositionOfStartAt(players.getPlayers().indexOf(player));
    }

    private Position findFinalPositionOfStartAt(int position) {
        return Position.of(position).findFinalLocation(new Rows(rows));
    }
}