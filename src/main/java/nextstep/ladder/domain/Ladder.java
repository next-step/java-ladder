package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {

    private static final int ZERO = 0;

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder initLadder(Users users, Height height) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(ZERO, height.getHeight())
                .forEach(number -> lines.add(Line.initLine(users)));
        return new Ladder(lines);
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<User, Integer> matchLadder(Map<User, Integer> userMap) {

        User[] userOrder = getUserOrder(userMap);

        for(Line line : lines) {
            userOrder = line.matchLine(userMap, userOrder);
        }

        return userMap;
    }

    public User[] getUserOrder(Map<User, Integer> userMap) {
        User[] userOrder = new User[userMap.size()];
        userMap.keySet()
                .forEach(key -> userOrder[userMap.get(key)] = key);
        return userOrder;
    }

    public int getUserFinalIndex(User user) {
        int index = user.getIndex();
        for(Line line : lines) {
            int move = line.getPoints().get(index).getDirection().getMove();
            index += move;
        }

        return index;
    }
}
