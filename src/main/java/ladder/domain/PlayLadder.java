package ladder.domain;

import java.util.Collections;
import java.util.List;

public class PlayLadder {
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    private PlayLadder(Players players, Prizes prizes, Ladder ladder) {
        validate(players, prizes);
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    private void validate(Players players, Prizes prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException("참가자 수와 당첨결과 수는 같아야 합니다.");
        }
    }

    public static PlayLadder of(Players players, Prizes prizes, Ladder ladder) {
        return new PlayLadder(players, prizes, ladder);
    }

    public LadderResults moveResult() {
        LadderResults ladderResults = LadderResults.of();

        for (Player player : players()) {
            ladderResults.put(player.name(), prize(player));
        }

        return ladderResults;
    }

    private String prize(Player player) {
        return prizes.value(moveResult(player));
    }

    private int moveResult(Player player) {
        return ladder.move(player.position());
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players.values());
    }

    public List<Prize> prizes() {
        return prizes.values();
    }

    public List<Row> rows() {
        return ladder.rows();
    }

    public int lengthMax() {
        return (int) Math.max(players.lengthMax(), prizes.lengthMax());
    }
}
