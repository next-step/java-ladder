package ladder.domain;

public class Player {
    private final String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        int NAME_MAX_LENGTH = 5;

        if (name.length() > NAME_MAX_LENGTH) {
            throw new PlayerNameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
