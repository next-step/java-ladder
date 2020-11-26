package step2.domain;

import step2.exception.PlayerCountException;

public class Row {

    private final int[] players;

    public Row(int playersCount) {
        validPlayerCount(playersCount);
        players = new int[playersCount];
    }
    private void validPlayerCount(int playersCount) {
        if(playersCount < 1){
            throw new PlayerCountException();
        }
    }

    public void drawLine(int startPosition) {
        players[startPosition] = initMoveCondition(MoveCondition.LEFT);
        players[startPosition + 1] = initMoveCondition(MoveCondition.RIGHT);
    }

    private int initMoveCondition(MoveCondition condition) {
        return condition.getMoveCondition();
    }

    public int move(int personPosition) {
        if (moveNot(personPosition)) {
            return personPosition;
        }
        if (moveLeft(personPosition)) {
            return personPosition + 1;
        }
        return personPosition - 1;
    }

    private boolean moveNot(int personPosition) {
        return players[personPosition] == initMoveCondition(MoveCondition.CENTER);
    }

    private boolean moveLeft(int personPosition) {
        return players[personPosition] == initMoveCondition(MoveCondition.LEFT);
    }


}
