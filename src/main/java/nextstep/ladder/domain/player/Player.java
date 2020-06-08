package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;
import nextstep.ladder.domain.ladder.HorizontalLocation;
import nextstep.ladder.domain.ladder.HorizontalMoveStrategy;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_VALUE_LENGTH = 5;

    private final String name;
    private HorizontalLocation horizontalLocation;

    public Player(String name, HorizontalLocation horizontalLocation) {
        validate(name);
        this.name = name;
        this.horizontalLocation = horizontalLocation;
    }

    public int length() {
        return this.name.length();
    }

    public String getName() {
        return this.name;
    }

    public int getPlayerLocationValue() {
        return this.horizontalLocation.parseIndexNumber();
    }

    public HorizontalLocation move(HorizontalMoveStrategy horizontalMoveStrategy) {
        this.horizontalLocation = horizontalMoveStrategy.move(this);
        return this.horizontalLocation;
    }

    public HorizontalLocation getHorizontalLocation() {
        return this.horizontalLocation;
    }

    private void validate(String nameValue) {
        validateNull(nameValue);
        validateNameLength(nameValue);
        validateEmptyName(nameValue);
    }

    private void validateNull(String nameValue) {
        if (nameValue == null) {
            throw new PlayerNameEmptyException("Player's name must not be null");
        }
    }

    private void validateNameLength(String nameValue) {
        if (nameValue.length() > MAX_NAME_VALUE_LENGTH) {
            throw new PlayerNameLengthException("Player's name length muse be smaller than 5");
        }
    }

    private void validateEmptyName(String nameValue) {
        if (nameValue.trim().isEmpty()) {
            throw new PlayerNameEmptyException("Player's name must not be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(horizontalLocation, player.horizontalLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, horizontalLocation);
    }
}
