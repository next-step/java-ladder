package laddergame.dto;

import laddergame.domain.PersonName;
import laddergame.domain.Reward;

public class RewardRecord {

    private final String playerName;
    private final String reword;

    public RewardRecord(String playerName, String reword) {
        this.playerName = playerName;
        this.reword = reword;
    }

    public static RewardRecord of(PersonName name, Reward reward){
        return new RewardRecord(name.toString(), reward.toString());
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getReword() {
        return reword;
    }
}
