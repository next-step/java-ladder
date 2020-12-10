package ladder.domain;

import java.util.Objects;


public class Player {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private String name;

    private Player(String name){
        validatePlayerName(name);
        this.name = name;
    }

    public static Player from(String name){
        return new Player(name);
    }

    public String getName() {
        return name;
    }

    private void validatePlayerName(String playerName) {
        if(playerName.length() > PLAYER_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("참여할 사람의 이름은 최대 "+PLAYER_NAME_MAX_LENGTH+" 글자 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
