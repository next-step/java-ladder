package ladder.domain;

import java.util.Optional;

public class Player {
    private static final int MAX_LENGTH = 5;

    private String name;
    private Position position;

    public Player(String name, Position position) {
        this.name = lengthValidation(name);
        this.position = position;
    }

    private String lengthValidation(String name) {
        return Optional.ofNullable(name)
                .filter(x -> x.length() <= MAX_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException("Player 이름은 최대 5자 까지 입니다."));
    }

    public String getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean isPlayerName(String name) {
        return this.name.equals(name);
    }

    public int lengthOfName() {
        return this.name.length();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
