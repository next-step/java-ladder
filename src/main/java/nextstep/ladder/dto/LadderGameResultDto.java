package nextstep.ladder.dto;

public class LadderGameResultDto {
    private final String playerName;
    private final String score;

    public LadderGameResultDto(String playerName, String score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return String.format("playerName : %s, Score : %s", playerName ,score);
    }
}
