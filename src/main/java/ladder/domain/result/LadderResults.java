package ladder.domain.result;

import ladder.domain.line.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {
    private static final String NOT_MATCHES_PLAYER_NAME_MESSAGE = "일치하는 이름이 없습니다.";

    private List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults of(Players players, Rewards rewards, Ladder ladder) {
        return new LadderResults(init(players, rewards, ladder));
    }

    private static List<LadderResult> init(Players players, Rewards rewards, Ladder ladder) {
        return IntStream.range(0, players.size())
                .mapToObj(position -> LadderResult.of(players.findPlayer(position), rewards.findReward(ladder.move(position))))
                .collect(Collectors.toList());
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }

    public LadderResult findByName(String name) {
        return ladderResults.stream()
                .filter(it -> it.isMatchesName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCHES_PLAYER_NAME_MESSAGE));
    }
}
