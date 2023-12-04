package ladder2.domain;

public class LadderResult {
    private final String playerName;
    private final String prize;

    public LadderResult(String playerName, String prize) {
        this.playerName = playerName;
        this.prize = prize;
    }

    public String playerName() {
        return playerName;
    }

    public String prize() {
        return prize;
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "playerName='" + playerName + '\'' +
                ", prize='" + prize + '\'' +
                '}';
    }
}
