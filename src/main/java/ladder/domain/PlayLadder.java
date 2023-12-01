package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, LadderResult> move() {
        PathTable pathTable = PathTable.of(ladder.ladder());

        return players.players()
                .stream()
                .map(player -> {
                    pathTable.navigate(player);
                    return new LadderResult(player.name(), prizes.value(player.position()));
                })
                .collect(Collectors.toMap(LadderResult::playerName, ladderResult -> ladderResult));
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players.players());
    }

    public List<Line> ladder() {
        return ladder.ladder();
    }

    public List<Prize> prizes() {
        return prizes.prizes();
    }

    public long lengthMax() {
        return Math.max(players.lengthMax(), prizes.lengthMax());
    }
}
