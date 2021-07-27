package nextstep.ladder.domain.player;

import nextstep.util.StringUtils;

public class Player {
    public static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private final String name;

    private Player(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("Name should less than or equal to " + MAXIMUM_LENGTH_OF_NAME);
        }
    }

    public static Player init(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
