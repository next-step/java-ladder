package nextstep.ladder.domain;

import java.util.List;

public class PlayLadderGame {
    private static PlayLadderGame playLadderGame = new PlayLadderGame();

    public Users generateResultsForAllPlayers(GameInfo paramGameInfo, Ladder paramLadder) {
        Users users = paramGameInfo.getUsers();
        List<User> userList = users.getUsers();
        List<Line> ladder = paramLadder.getLadder();
        List<Result> results = paramGameInfo.getResults().getResults();

        for (int i = 0; i < users.getCountOfPerson(); i++) {
            int index = initIndex(users.getCountOfPerson(), i);
            index = repeatLineForFindIndex(ladder, users.getCountOfPerson() - 1, index);
            userList.get(i).setResult(results.get(index).getResult());
        }
        return new Users(userList);
    }

    private int plusIndex(Point point) {
        return point.plusIndex();
    }

    private int minusIndex(Point point) {
        return point.minusIndex();
    }

    private int judgeIndex(Point point, boolean isLeftLine) {
        return point.judgeIndex(isLeftLine);
    }

    private int initIndex(int userCount, int i) {
        int index = i;
        if (i >= userCount) {
            index = userCount - 1;
        }
        return index;
    }

    private int repeatLineForFindIndex(List<Line> ladder, int last, int index) {
        for (int j = 0; j < ladder.size(); j++) {
            List<Point> points = ladder.get(j).getPoints();
            Point point = getPoint(points, last, index);
            point.setIndex(index);
            index = getIndex(last, index, points, point);
        }
        return index;
    }

    private int getIndex(int last, int index, List<Point> points, Point point) {
        if (index == last) {
            index = minusIndex(point);
            return index;
        }
        if (index == 0) {
            index = plusIndex(point);
            return index;
        }
        if (index > 0 && index < last) {
            Point prePoint = points.get(index - 1);
            index = judgeIndex(point, prePoint.isNextPoint());
        }
        return index;
    }

    private Point getPoint(List<Point> points, int last, int index) {
        if (index < last) {
            return points.get(index);
        }
        return points.get(index - 1);
    }

    public static PlayLadderGame getPlayLadderGame() {
        return playLadderGame;
    }
}
