package ladder.domain.player;

import ladder.domain.ladder.ladderInfo.LineCount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayers {

    private final List<LadderPlayer> ladderPlayers;

    private LadderPlayers(String[] playerNames) {
        validatePlayer(playerNames);
        List<LadderPlayer> ladderPlayers = createLadderPlayers(playerNames);
        this.ladderPlayers = ladderPlayers;
    }

    public static LadderPlayers participate(String[] playerNames) {
        return new LadderPlayers(playerNames);
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

    public LadderPlayer getLadderPlayer(int index) {
        return ladderPlayers.get(index);
    }

    private List<LadderPlayer> createLadderPlayers(String[] playerNames) {
        return Arrays.stream(playerNames)
                .map(LadderPlayer::create)
                .collect(Collectors.toList());
    }

    private void validatePlayer(String[] playerNames) {
        if (playerNames == null || playerNames.length < 1) {
            throw new IllegalArgumentException("플에이어를 입력하세요");
        }
    }

}
