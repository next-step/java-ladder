package domain;

import java.util.Map;

public class LadderResult {
    public static final String PLAYER_NOT_FOUND = "해당 Player가 존재하지 않습니다.";

    private final Map<Player, String> ladderResult;

    public LadderResult(Map<Player, String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getResult(Player player) {
        if (!ladderResult.containsKey(player)) {
            throw new IllegalArgumentException(PLAYER_NOT_FOUND);
        }
        return ladderResult.get(player);
    }

    public String getResult(String playerName) {
        Player player = Player.from(playerName);
        if (!ladderResult.containsKey(player)) {
            throw new IllegalArgumentException(PLAYER_NOT_FOUND);
        }
        return ladderResult.get(player);
    }

    public String resultAllToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Player, String> entry : ladderResult.entrySet()) {
            sb.append(entry.getKey())
                    .append(" : ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
