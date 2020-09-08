package ladder.domain.result;

import ladder.domain.line.Ladder;
import ladder.domain.player.Players;
import ladder.domain.point.Position;
import ladder.domain.reward.Rewards;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LadderResults {
    private static final int START_POSITION = 0;
    private static final String NOT_MATCHES_PLAYER_NAME_MESSAGE = "일치하는 이름이 없습니다.";

    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults of(Players players, Rewards rewards, Ladder ladder) {
        return new LadderResults(init(players, rewards, ladder));
    }

    private static List<LadderResult> init(Players players, Rewards rewards, Ladder ladder) {
        return IntStream.range(START_POSITION, players.size())
                .mapToObj(position -> LadderResult.of(players.findPlayerName(position),
                        rewards.findPrize(ladder.move(Position.of(position)))))
                .collect(toList());
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }

    public LadderResult findByName(String name) {
        return ladderResults.stream()
                .filter(ladderResult -> ladderResult.isEqualsName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCHES_PLAYER_NAME_MESSAGE));
    }
}
