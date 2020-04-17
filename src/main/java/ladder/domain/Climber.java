package ladder.domain;


import java.util.List;
import java.util.Random;

public class Climber {

    private final LadderMap ladderMap;
    private final Users users;

    private Climber(String userNames, int height, CrossRoadStrategy crossRule) {
        this.users = Users.of(userNames);
        this.ladderMap =  LadderMap.of(users, height, crossRule);
    }

    public static Climber of(String userNames, int height, CrossRoadStrategy crossRule) {
        return new Climber(userNames, height, crossRule);
    }

    public LadderMap targetLadder() {
        return ladderMap;
    }

    public Reward offerPrize(String rewards) {
        return Reward.of(rewards, users.size());
    }

    public List<String> participantNames() {
        return users.participantNames();
    }

    public List<List<Boolean>> getLadderMapList(LadderMap ladderMap) {
        return ladderMap.getLadderMap();
    }

    public List<String> getRewards(Reward reward) {
        return reward.toList();
    }
}
