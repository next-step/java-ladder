package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final static String LADDER_GAME_ERROR = "결과 수와 참여자 수는 같아야 합니다.";
    private final List<Player> players;
    private final Ladder ladder;

    public LadderGame(final List<String> players, final Ladder ladder) {
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        this.ladder = ladder;
    }

    // todo
    public LadderResults climbLadder(List<String> results) {
        if (results.size() != players.size()) {
            throw new IllegalArgumentException(LADDER_GAME_ERROR);
        }
        Map<Player, String> resultMap = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            resultMap.put(players.get(i), results.get(doLadderGame(i)));
        }
        return new LadderResults(resultMap);
    }

    // todo
    public int doLadderGame(int index) {
        for (Line line : ladder.getLines()) {
            if (line.getPoints().get(index)) {
                --index;
            } else if (index + 1 != line.getPoints().size()) {
                if (line.getPoints().get(index + 1))
                    ++index;
            }
        }
        return index;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
