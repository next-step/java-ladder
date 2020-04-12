package ladder.domain;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Climber {

    private Users users;

    private Climber(String userNames) {
        this.users = Users.of(userNames);
    }

    public static Climber of(String userNames) {
        return new Climber(userNames);
    }

    public LadderMap createLadder(int height) {
        CrossRoadStrategy halfPercentCreate = () -> new Random().nextInt(10) >= 5;
        return LadderMap.of(users, height, halfPercentCreate);
    }

    public Reward offerPrize(String rewards) {
        return Reward.of(rewards, users.size());
    }

    public List<String> getUserNames() {
        return users.toList()
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public List<List<Boolean>> getLadderMapList(LadderMap ladderMap) {
        return ladderMap.getLadderMap();
    }

    public List<String> getRewards(Reward reward) {
        return reward.toList();
    }
}
