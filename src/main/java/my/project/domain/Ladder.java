package my.project.domain;

import my.project.dto.Result;
import my.project.dto.Rewards;
import my.project.dto.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int FIRST_LINE = 0;
    public static final int FIRST_VERTICAL = 0;
    public static final int SECOND_VERTICAL = 2;
    public static final int PREVIOUS_NUMBER = 1;
    public static final int PREVIOUS_BRIDGE = 2;
    public static final int LAST_VERTICAL = 2;
    public static final int LAST_BRIDGE = 2;
    public static final int NEXT = 1;
    public static final int NEXT_VERTICAL = 2;

    private final List<Line> lines;
    private final Users users;
    private final int height;

    public Ladder(Users users, int height) {
        lines = new ArrayList<>();
        this.users = users;
        this.height = height;

        build(users);
        balance();
    }

    private void build(Users users) {
        IntStream.range(Line.ZERO, height)
                .forEach(i -> lines.add(new Line(users.getUsers().size())));
    }

    private void balance() {
        IntStream.range(FIRST_LINE, height)
                .forEach(i -> IntStream.range(FIRST_LINE, lines.get(i).getPoints().size())
                        .forEach(j -> {
                            if (isNoBridgeBetweenLines(i, j)) {
                                buildSingleBridge(i, j);
                                destroySideBridges(i, j);
                            }
                        }));
    }

    private void buildSingleBridge(int i, int j) {
        lines.get(i).getPoints().remove(j);
        lines.get(i).getPoints().add(j, Symbol.BRIDGE);
    }

    private void destroySideBridges(int i, int j) {
        if (hasPreviousBridge(j)) {
            lines.get(i).getPoints().remove(j - PREVIOUS_BRIDGE);
            lines.get(i).getPoints().add(j - PREVIOUS_BRIDGE, Symbol.NONE);
        }
        if (hasNextBridge(i, j)) {
            lines.get(i).getPoints().remove(j + LAST_BRIDGE);
            lines.get(i).getPoints().add(j + LAST_BRIDGE, Symbol.NONE);
        }
    }

    private boolean isNoBridgeBetweenLines(int i, int j) {
        return i != FIRST_LINE
                && lines.get(i).getPoints().get(j) == Symbol.NONE
                && lines.get(i - PREVIOUS_NUMBER).getPoints().get(j) == Symbol.NONE;
    }

    private boolean hasPreviousBridge(int j) {
        return j > SECOND_VERTICAL;
    }

    private boolean hasNextBridge(int i, int j) {
        return j < lines.get(i).getPoints().size() - LAST_VERTICAL;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Result> results(String username, Rewards rewards) {
        if ("all".equals(username)) {
            return users.getUsers().stream()
                    .map(user -> result(user.getName().trim(), rewards))
                    .collect(Collectors.toList());
        }

        List<Result> resultList = new ArrayList<>();
        resultList.add(result(username, rewards));
        return resultList;
    }

    private Result result(String username, Rewards rewards) {
        Point point = users.getUserPoint(username);
        while (point.getY() < height) {
            IntStream.range(FIRST_LINE, height)
                    .forEach(y -> IntStream.range(FIRST_LINE, lines.get(y).getPoints().size())
                            .forEach(x -> {
                                if (point.getX() == x && point.getY() == y) {
                                    move(point, x, y);

                                    if (y == height) {
                                        lastMove(point, x, y);
                                    }
                                }
                            }));
        }

        Reward reward = rewards.getReward(point.getX());
        return new Result(username, reward);
    }

    private void move(Point point, int x, int y) {
        if (hasRightSideBridge(x, y)) {
            point.setLocation(x + NEXT_VERTICAL, y + NEXT);
            return;
        }
        if (hasLeftSideBridge(x, y)) {
            point.setLocation(x - NEXT_VERTICAL, y + NEXT);
            return;
        }
        point.setLocation(x, y + NEXT);
    }

    private void lastMove(Point point, int x, int y) {
        if (hasRightSideBridge(x, y)) {
            point.setLocation(x + NEXT_VERTICAL, y);
            return;
        }
        if (hasLeftSideBridge(x, y)) {
            point.setLocation(x - NEXT_VERTICAL, y);
        }
    }

    private boolean hasRightSideBridge(int x, int y) {
        if (x + NEXT == lines.get(y).getPoints().size()) {
            return false;
        }
        return lines.get(y).getPoints().get(x + NEXT) == Symbol.BRIDGE;
    }

    private boolean hasLeftSideBridge(int x, int y) {
        if (x - NEXT < FIRST_VERTICAL) {
            return false;
        }
        return lines.get(y).getPoints().get(x - NEXT) == Symbol.BRIDGE;
    }
}
