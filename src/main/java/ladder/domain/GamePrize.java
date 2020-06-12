package ladder.domain;

public class GamePrize {

    private final String name;

    public GamePrize(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new LadderBuildingException(LadderBuildingException.INVALID_GAME_PRIZE_NAME);
        }
    }

    public String getName() {
        return name;
    }
}
