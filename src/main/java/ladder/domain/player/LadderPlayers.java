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

    private static void validatePlayer(String[] playerNames) {
        Arrays.stream(playerNames).forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("사람 이름은 최대 5글자 입니다.");
            }
        });
    }

}
