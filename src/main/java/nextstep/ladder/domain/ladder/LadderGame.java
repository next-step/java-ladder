package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.GenerateLadderLineStrategy;
import nextstep.ladder.domain.user.Users;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Users users;
    private final Lines lines;
    private final Rewards rewards;

    public LadderGame(Users users, Height height, GenerateLadderLineStrategy generate) {
        this(users, new Lines(IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(users.size(), generate))
                .collect(Collectors.toList())), null);
    }

    public LadderGame(Users users, Lines lines, Rewards rewards) {
        this.users = users;
        this.lines = lines;
        this.rewards = rewards;
    }

    public LadderResults play() {
        return new LadderResults(IntStream.range(0, users.size())
                .mapToObj(this::generateLadderResult)
                .toList());
    }

    private LadderResult generateLadderResult(int userIndex) {
        return new LadderResult(users.getUsers().get(userIndex), rewards.findReward(lines.move(userIndex)));
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }

}
