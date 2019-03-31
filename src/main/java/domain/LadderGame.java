package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private List<User> users;
    private Ladder ladder;

    public LadderGame(List<String> userNames, Integer height, PointLottery pointLottery) {
        users = IntStream.range(0, userNames.size())
            .mapToObj(i -> new User(userNames.get(i), i+1))
            .collect(Collectors.toList());

        List<Point> points = Point.valuesOf(userNames.size(), height);
        ladder = new Ladder(points, pointLottery.draw(points));
    }

    public List<User> getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Integer longestUserNameLength() {
        return users.stream()
            .map(User::getName)
            .mapToInt(String::length)
            .max()
            .orElse(0);
    }
}
