package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.List;

public class Ladder {

    private final Lines lines;
    private final Users users;

    public static Ladder of(int floor, List<String> users, StepStrategy strategy) {
        return new Ladder(
                Floor.of(floor),
                Users.of(users),
                strategy
        );
    }

    private Ladder(Floor floor, Users users, StepStrategy strategy) {
        this.users = users;
        this.lines = Lines.of(floor, users.countOfUsers(), strategy);
    }

    public List<String> getParticipants() {
        return this.users.toNameList();
    }

    public List<List<StepType>> getLadderInfo() {
        return this.lines.toList();
    }
}
