package nextstep.ladder.domain.player;

import nextstep.ladder.domain.Position;

import java.util.Objects;

public class Player {
    private final static int MAX_NAME_LENGTH = 5;
    private final static int ZERO = 0;

    private final String name;
    private Position currentLinePosition;
    private Position currentHeightPosition;

    public Player(String name, int linePosition) {
        this.validateName(name);
        this.name = name;
        this.currentLinePosition = new Position(linePosition);
        this.currentHeightPosition = new Position(ZERO);
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("name length must be less than %d", MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return this.name;
    }

    public Position getCurrentLinePosition() {
        return this.currentLinePosition;
    }

    public Position getCurrentHeightPosition() {
        return this.currentHeightPosition;
    }

    public void move(Position linePosition) {
        this.currentLinePosition = linePosition;
        this.currentHeightPosition = this.currentHeightPosition.nextPosition();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (Objects.isNull(obj) || this.getClass() != obj.getClass()) {
            return false;
        }

        Player player = (Player) obj;
        return this.name.equals(player.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
