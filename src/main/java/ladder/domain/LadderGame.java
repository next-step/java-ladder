package ladder.domain;

import lombok.Getter;

import java.util.Arrays;

public class LadderGame {
    private static final String REGEX = ",";

    @Getter
    private Ladder ladder;
    @Getter
    private Users users;

    public LadderGame(String userNameValues, String heightValue, String resultValues) {
        String[] userNames = userNameValues.split(REGEX);

        this.ladder = new Ladder(userNames.length, Integer.parseInt(heightValue), new LadderReward(resultValues, userNames.length));
        this.users = new Users(Arrays.asList(userNames), ladder);
    }
}
