package my.project.domain;

import my.project.dto.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {
    public static final int NEXT = 1;

    private final Users users;
    private final Ladder ladder;

    public Result(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public List<ResultSet> get(String username, Rewards rewards) {
        if ("all".equals(username)) {
            return resultsAll(rewards);
        }
        return resultOne(username, rewards);
    }

    private List<ResultSet> resultsAll(Rewards rewards) {
        return users.getUsers().stream()
                .map(user -> result(user.getName().trim(), rewards))
                .collect(Collectors.toList());
    }

    private List<ResultSet> resultOne(String username, Rewards rewards) {
        List<ResultSet> resultList = new ArrayList<>();
        resultList.add(result(username, rewards));
        return resultList;
    }

    private ResultSet result(String username, Rewards rewards) {
        Point point = users.getUserPoint(username);
        while (toEndLine(point)) {
            moving(point);
        }
        return new ResultSet(username, rewards.getReward(point.getX()));
    }

    private boolean toEndLine(Point point) {
        return point.getY() < ladder.getHeight();
    }

    private void moving(Point point) {
        for (int lineIndex = 0; lineIndex < ladder.getHeight(); lineIndex++) {
            searchLine(point, lineIndex);
        }
    }

    private void searchLine(Point point, int y) {
        IntStream.range(Lines.FIRST_LINE, ladder.getLines().getSize(y))
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
            point.move(x + Lines.NEXT_VERTICAL, y + NEXT);
            return;
        }
        if (hasLeftSideBridge(x, y)) {
            point.move(x - Lines.NEXT_VERTICAL, y + NEXT);
            return;
        }
        point.move(x, y + NEXT);
    }

    private void lastLineAction(Point point, int y, int x) {
        if (y == ladder.getHeight()) {
            lastMove(point, x, y);
        }
    }

    private void lastMove(Point point, int x, int y) {
        if (hasRightSideBridge(x, y)) {
            point.move(x + Lines.NEXT_VERTICAL, y);
            return;
        }
        if (hasLeftSideBridge(x, y)) {
            point.move(x - Lines.NEXT_VERTICAL, y);
        }
    }

    private boolean hasRightSideBridge(int x, int y) {
        if (x + NEXT == ladder.getLines().getSize(y)) {
            return false;
        }
        return ladder.getLines().getLine(y).get(x + NEXT) == Symbol.BRIDGE;
    }

    private boolean hasLeftSideBridge(int x, int y) {
        if (x - NEXT < Lines.FIRST_VERTICAL) {
            return false;
        }
        return ladder.getLines().getLine(y).get(x - NEXT) == Symbol.BRIDGE;
    }

}
