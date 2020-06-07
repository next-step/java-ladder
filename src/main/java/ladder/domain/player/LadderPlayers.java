package ladder.domain.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayers {

    private final List<LadderPlayer> ladderPlayers;

    private LadderPlayers(List<LadderPlayer> ladderPlayers) {
        this.ladderPlayers = ladderPlayers;
    }

    public static LadderPlayers participate(String[] playerNames) {
        validatePlayer(playerNames);
        List<LadderPlayer> ladderPlayers = Arrays.stream(playerNames)
                                                .map(LadderPlayer::create)
                                                .collect(Collectors.toList());
        return new LadderPlayers(ladderPlayers);
    }

    public int getPlayerCount() {
        return ladderPlayers.size();
    }

    public List<LadderPlayer> getLadderPlayers() {
        return ladderPlayers;
    }

    private static void validatePlayer(String[] playerNames) {
        if (playerNames.length < 1) {
            throw new IllegalArgumentException("플에이어를 입력하세요");
        }
    }

}
