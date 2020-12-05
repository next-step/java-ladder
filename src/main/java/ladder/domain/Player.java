package ladder.domain;

import java.util.Objects;

import static ladder.domain.LadderGameConfig.PLAYER_NAME_MAX_LENGTH;

public class Player {

    private String name;

    public Player(String name){
        validatePlayerName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validatePlayerName(String playerName) {
        if(playerName.length() > PLAYER_NAME_MAX_LENGTH){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_MAX_PLAYER_NAME.getErrorMessage());
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
