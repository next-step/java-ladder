package ladder.model;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;

    public LadderGame(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public static LadderGame of(List<String> userNames, int height, LadderGenerateStrategy ladderGenerateStrategy) {
        Users users = Users.of(userNames);
        Ladder ladder = Ladder.of(height, users.getSize(), ladderGenerateStrategy);

        return new LadderGame(ladder, users);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<String> getUsersName() {
        return users.getUserNames();
    }

    public void play() {
        ladder.rideLadder(users);
    }

}
