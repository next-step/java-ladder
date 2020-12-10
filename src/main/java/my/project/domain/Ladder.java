package my.project.domain;

import my.project.dto.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int FIRST_LINE = 0;
    public static final int FIRST_VERTICAL = 0;
    public static final int NEXT = 1;
    public static final int NEXT_VERTICAL = 2;

    private final Lines lines;
    private final Users users;
    private final int height;

    public Ladder(Users users, int height) {
        lines = new Lines(users, height);
        this.users = users;
        this.height = height;
    }

    public List<Result> results(String username, Rewards rewards) {
        if ("all".equals(username)) {
            return resultsAll(rewards);
        }
        return resultOne(username, rewards);
    }

    private List<Result> resultsAll(Rewards rewards) {
        return users.getUsers().stream()
                .map(user -> result(user.getName().trim(), rewards))
                .collect(Collectors.toList());
    }

    private List<Result> resultOne(String username, Rewards rewards) {
        List<Result> resultList = new ArrayList<>();
        resultList.add(result(username, rewards));
        return resultList;
    }

    private Result result(String username, Rewards rewards) {
        Point point = users.getUserPoint(username);
        while (toEndLine(point)) {
            moving(point);
        }
        return new Result(username, rewards.getReward(point.getX()));
    }

    private boolean toEndLine(Point point) {
        return point.getY() < height;
    }

    private void moving(Point point) {
        for (int lineIndex = 0; lineIndex < height; lineIndex++) {
            searchLine(point, lineIndex);
        }
    }

    private void searchLine(Point point, int y) {
        IntStream.range(FIRST_LINE, lines.getSize(y))
                .forEach(x -> find(point, y, x));
    }

    private void find(Point point, int y, int x) {
        if (point.getX() == x && point.getY() == y) {
            move(point, x, y);
            lastLineAction(point, y, x);
        }
    }

    private void move(Point point, int x, int y) {
        if (hasRightSideBridge(x, y)) {
            point.move(x + NEXT_VERTICAL, y + NEXT);
            return;
        }
        if (hasLeftSideBridge(x, y)) {
            point.move(x - NEXT_VERTICAL, y + NEXT);
            return;
        }
        point.move(x, y + NEXT);
    }

    private void lastLineAction(Point point, int y, int x) {
        if (y == height) {
            lastMove(point, x, y);
        }
    }

    private void lastMove(Point point, int x, int y) {
        if (hasRightSideBridge(x, y)) {
            point.move(x + NEXT_VERTICAL, y);
            return;
        }
        if (hasLeftSideBridge(x, y)) {
            point.move(x - NEXT_VERTICAL, y);
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

    public Lines getLines() {
        return lines;
    }
}
