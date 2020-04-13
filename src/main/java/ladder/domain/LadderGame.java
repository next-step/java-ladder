package ladder.domain;


import java.util.List;

public class LadderGame {

    private Users users;
    private LadderMap ladderMap;

    private LadderGame(Users users, LadderMap ladderMap) {
        this.users = users;
        this.ladderMap = ladderMap;
    }

    public static LadderGame of(Users users, LadderMap ladderMap) {
        return new LadderGame(users, ladderMap);
    }

    public int userClaim(String name) {
        User user = users.findUserByName(name);
        for (Line line : ladderMap.toList()) {

        }
    }
}
