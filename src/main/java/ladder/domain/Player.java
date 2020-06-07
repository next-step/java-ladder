package ladder.domain;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isNullOrEmpty(name) || isInvalidLength(name)) {
            throw new LadderBuildingException(LadderBuildingException.INVALID_PLAYER_NAME);
        }
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private boolean isInvalidLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }
}
