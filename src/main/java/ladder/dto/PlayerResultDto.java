package ladder.dto;


public class PlayerResultDto {
    private String playerName;
    private String resultName;

    public PlayerResultDto(String playerName, String resultName) {
        this.playerName = playerName;
        this.resultName = resultName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getResultName() {
        return resultName;
    }
}
