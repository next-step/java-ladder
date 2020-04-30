package ladder.domain;


import ladder.dto.UserStatusDto;

import java.util.ArrayList;
import java.util.List;

public class Climber {

    private final LadderMap ladderMap;
    private final Users users;
    private final LadderGame ladderGame;
    private Reward reward;

    private Climber(String userNames, int height, CrossRoadStrategy crossRule) {
        this.users = Users.of(userNames);
        this.ladderMap =  LadderMap.of(users, height, crossRule);
        this.ladderGame = LadderGame.of(users, ladderMap);
    }

    public static Climber of(String userNames, int height, CrossRoadStrategy crossRule) {
        return new Climber(userNames, height, crossRule);
    }

    public LadderMap targetLadder() {
        return ladderMap;
    }

    public Reward offerPrize(String rewards) {
        this.reward = Reward.of(rewards, users.size());
        return reward;
    }

    public int climbByUser(String name) {
        return ladderGame.claimByUser(name);
    }

    public List<UserStatusDto> climbAll() {
        Users climbResultUser = ladderGame.claimAll();
        List<UserStatusDto> userStatusDtos = new ArrayList<>();
        for (User user : climbResultUser.toList()) {
            userStatusDtos.add(userGameResult(user.getName(), user.position()));
        }
        return userStatusDtos;
    }
    private UserStatusDto userGameResult(String name, int position) {
        String prize = reward.prizeByEachPosition(position);
        return new UserStatusDto(name, prize);
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
