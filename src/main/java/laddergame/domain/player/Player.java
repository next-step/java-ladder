package laddergame.domain.player;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.navigator.Navigator;
import laddergame.domain.prize.Prize;
import laddergame.domain.utils.Constants;

import java.util.List;

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

    public Player climbLadder(Ladder ladder, List<Prize> prizes) {
        int initialPosition = position;
        ladder.climb(this);

        prize = prizes.get(this.getPosition()).getContent();
        position = initialPosition;
        return this;
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

    public String getPrize() {
        return prize;
    }
}