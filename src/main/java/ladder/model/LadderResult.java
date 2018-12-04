package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private People people;
    private Rewards rewards;
    private List<Line> lines;

    private LadderResult(String names, String rewards, List<Line> lines) {
        this.people = People.of(names);
        this.rewards = Rewards.of(rewards);
        this.lines = lines;
    }

    public static LadderResult of(String names, String rewards, int length) {
        List<Line> lines = new ArrayList<>();
        int countOfPerson = names.split(",").length;
        int countOfReward = rewards.split(",").length;

        if(countOfPerson != countOfReward) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < length; i++) {
            lines.add(Line.of(countOfPerson));
        }
        return new LadderResult(names, rewards, lines);
    }

    public static LadderResult of(String names, String rewards, List<Line> lines) {
        return new LadderResult(names, rewards, lines);
    }
}

