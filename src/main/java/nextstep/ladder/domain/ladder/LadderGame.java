package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.GenerateLadderLineStrategy;
import nextstep.ladder.domain.user.Users;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Users users;
    private final Lines lines;

    public LadderGame(Users users, Height height, GenerateLadderLineStrategy generate) {
        this(users, new Lines(IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(users.size(), generate))
                .collect(Collectors.toList())));
    }

    public LadderGame(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }
}
