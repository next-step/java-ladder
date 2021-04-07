package nextstep.ladder.service;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;
import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.wrapper.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public final class LadderFactory {

    private LadderFactory() { }

    public static Ladder valueOf(
            final Participants participants, final Height height, final LineGenerator generator) {
        Line[] lines = Stream.generate(() -> generator.createLine(participants.size()))
                .limit(height.size())
                .toArray(Line[]::new);
        return Ladder.valueOf(lines);
    }

    public static LadderResult rideLadder(
            final Participants participants, final Ladder ladder, final LadderRewards ladderRewards) {

        Map<User, Reward> result = new LinkedHashMap<>();
        Set<User> users = participants.getUsers();

        for (User user : users) {
            Position rewardPosition = ladder.findEndPosition(user.position());
            Reward reward = ladderRewards.findReward(rewardPosition);
            result.put(user, reward);
        }

        return LadderResult.valueOf(result);
    }
}
