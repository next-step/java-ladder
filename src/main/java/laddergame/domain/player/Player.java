package laddergame.domain.player;

import laddergame.domain.utils.Constants;

public class Player {
    private String name;
    private int position;
    private String prize;

    public Player(int position, String name) {
        if (name.length() > Constants.PLAYER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("player 이름을 최대 5글자까지 부여할 수 있다");
        }
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveRight() {
        position++;
    }

    public void moveLeft() {
        position--;
    }

    public void takePrize(String prize) {
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    public void initPosition(int initialPosition) {
        this.position = initialPosition;
    }
}