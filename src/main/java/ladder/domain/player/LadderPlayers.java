package ladder.domain.player;

import ladder.domain.ladder.LineCount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayers {

    private final List<LadderPlayer> ladderPlayers;

    private LadderPlayers(List<LadderPlayer> ladderPlayers) {
        this.ladderPlayers = ladderPlayers;
    }

    public static LadderPlayers participate(String[] playerNames) {
        validatePlayer(playerNames);
        List<LadderPlayer> ladderPlayers = createLadderPlayers(playerNames);
        return new LadderPlayers(ladderPlayers);
    }

    public int getPlayerCount() {
        return ladderPlayers.size();
    }

    public LineCount getRequestLineCount() {
        return LineCount.inputLineCount(ladderPlayers.size());
    }

    public List<LadderPlayer> getLadderPlayers() {
        return Collections.unmodifiableList(ladderPlayers);
    }

    private static List<LadderPlayer> createLadderPlayers(String[] playerNames) {
        return Arrays.stream(playerNames)
                .map(LadderPlayer::create)
                .collect(Collectors.toList());
    }

    private static void validatePlayer(String[] playerNames) {
        if (playerNames == null || playerNames.length < 1) {
            throw new IllegalArgumentException("플에이어를 입력하세요");
        }
    }

}
