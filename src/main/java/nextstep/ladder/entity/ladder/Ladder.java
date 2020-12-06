package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.Objects;

public class Ladder {

    private final Floor firstFloor;
    private Users users;
    private GameResults gameResults;

    private Ladder(Floor firstFloor) {
        this.firstFloor = firstFloor;
    }

    public static Ladder create(LadderHeight ladderHeight, FloorGenerator floorGenerator) {

        Floor firstFloor = floorGenerator.create();

        Floor current = firstFloor;
        Floor next;

        for (int count = 2; count <= ladderHeight.getHeight(); count++) {
            next = floorGenerator.create();
            current.next(next);
            current = next;
        }

        return new Ladder(firstFloor);
    }

    public int goDown(int startPosition) {

        throwIfNotReadyUsers();
        throwIfNotReadyGameResults();

        return goDownRecursively(firstFloor, firstFloor.moveTo(startPosition))
                .getPosition();
    }

    public GameResult goDown(User user) {

        throwIfNotReadyUsers();
        throwIfNotReadyGameResults();

        int startPosition = users.getPosition(user);

        int arrivalPosition = goDownRecursively(firstFloor, firstFloor.moveTo(startPosition))
                .getPosition();
        gameResults.map(user, arrivalPosition);

        return gameResults.getGameResult(arrivalPosition);
    }

    private Point goDownRecursively(Floor floor, Point point) {

        if (!floor.hasNext()) {
            return getPointOnLastFloor(point);
        }

        int nextPosition = point.isLinked() ? point.getLinkPoint().getPosition() : point.getPosition();
        Floor nextFloor = floor.getNextFloor();
        Point nextPoint = nextFloor.moveTo(nextPosition);

        return goDownRecursively(nextFloor, nextPoint);
    }

    private Point getPointOnLastFloor(Point point) {
        if (point.isLinked()) {
            return point.getLinkPoint();
        }
        return point;
    }

    public Floor getFirstFloor() {
        return firstFloor;
    }

    private void throwIfNotReadyUsers() {
        if (Objects.isNull(users)) {
            throw new IllegalStateException("게임을 진행할 사용자를 입력해주세요.");
        }


    }
    private void throwIfNotReadyGameResults() {
        if (Objects.isNull(gameResults)) {
            throw new IllegalStateException("게임 결과를 입력해주세요.");
        }
    }
    
    public void startWith(Users users) {
        this.users = users;
    }

    public void arrivalAt(GameResults gameResults) {
        this.gameResults = gameResults;
    }
}
