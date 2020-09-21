package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.ladder.Location;

import java.util.*;
import java.util.stream.IntStream;

public class LadderGameInfo {
    private final Players players;
    private final LadderRewards ladderRewards;

    public LadderGameInfo(final Players players, final LadderRewards ladderRewards) {
        if (players.size() != ladderRewards.size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 한다.");
        }
        this.players = Objects.requireNonNull(players);
        this.ladderRewards = Objects.requireNonNull(ladderRewards);
    }

    public LadderGameResult apply(final LadderResult ladderResult) {
        Map<Player, LadderReward> result = new HashMap<>();
        IntStream.range(0, players.size())
                .forEach(location -> {
                    Location startLocation = Location.from(location);
                    Player player = players.getPlayer(startLocation);
                    LadderReward reward = ladderRewards.getReward(ladderResult.getFinalLocation(startLocation));
                    result.put(player, reward);
                });
        return LadderGameResult.from(result);
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public List<LadderReward> getLadderRewards() {
        return new ArrayList<>(ladderRewards.getLadderRewards());
    }
}
