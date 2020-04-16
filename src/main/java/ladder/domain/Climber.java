package ladder.domain;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Climber {

    private final LadderMap ladderMap;
    private final Users users;

    private Climber(String userNames, int height) {
        this.users = Users.of(userNames);
        CrossRoadStrategy halfPercentCreate = () -> new Random().nextInt(10) >= 5;
        this.ladderMap =  LadderMap.of(users, height, halfPercentCreate);
    }

    public static Climber of(String userNames, int height) {
        return new Climber(userNames, height);
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
