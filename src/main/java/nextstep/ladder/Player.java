package nextstep.ladder;

import static nextstep.ladder.CommonConstans.NAME_SIZE;

public class Player {

    String player;


    public Player(String player) {
        if (player.length() > NAME_SIZE) {
            throw new IllegalArgumentException("player 이름은 5글자가 초과할 수 없습니다.");
        }
        this.player = player;
    }

    public static Player of(String player) {
        return new Player(player);
    }

    public int getPlayerNameSize() {
        return this.player.length();
    }

    public String getPlayer() {
        return this.player;
    }


}
