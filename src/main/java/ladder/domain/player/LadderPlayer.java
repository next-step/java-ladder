package ladder.domain.player;

public class LadderPlayer {

    private String playerName;

    private LadderPlayer(String playerName) {
        validatePlayer(playerName);
        this.playerName = playerName;
    }

    public static LadderPlayer create(String playerName) {
        return new LadderPlayer(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    private void validatePlayer(String playerName) {
        if (playerName.length() > 5) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자 입니다.");
        }

        if (playerName == null || "".equals(playerName.trim())) {
            throw new IllegalArgumentException("사용자가 입력되지 않았습니다.");
        }
    }

}
