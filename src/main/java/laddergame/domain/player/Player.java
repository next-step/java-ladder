package laddergame.domain.player;

import laddergame.domain.utils.Constants;

public class Player {
    private String name;

    public Player(String name) {
        if(name.length() > Constants.PLAYER_NAME_LENGTH_LIMIT){
            throw new IllegalArgumentException("player 이름을 최대 5글자까지 부여할 수 있다");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}