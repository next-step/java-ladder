package ladder.domain;


public class LadderGame {

    private final Users users;
    private final LadderMap ladderMap;

    public LadderGame(Users users, LadderMap ladderMap) {
        this.users = users;
        this.ladderMap = ladderMap;
    }

    public static LadderGame of(Users users, LadderMap ladderMap) {
        return new LadderGame(users, ladderMap);
    }

    public int claimByUser(String name) {
        User user = users.findUserByName(name);
        for (Line line : ladderMap.toList()) {
            SteerRule steerRule = line.steerWay(user.position());
            user.move(steerRule);
        }
        return user.position();
    }

    public LadderMap inquiryLadderMap() {
        return ladderMap;
    }
}
