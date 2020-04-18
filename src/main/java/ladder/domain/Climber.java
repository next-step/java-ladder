package ladder.domain;


import ladder.dto.UserStatusDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Climber {

    private final LadderMap ladderMap;
    private final Users users;
    private final LadderGame ladderGame;

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
        return Reward.of(rewards, users.size());
    }

    public UserStatusDto climbByUser(String name) {
        return new UserStatusDto(name, ladderGame.claimByUser(name));
    }

    public List<UserStatusDto> climbAll() {
        Users climbResultUser = ladderGame.claimAll();
        List<UserStatusDto> userStatusDtos = new ArrayList<>();
        for (User user : climbResultUser.toList()) {
            userStatusDtos.add(new UserStatusDto(user.getName(), user.position()));
        }
        return userStatusDtos;
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
