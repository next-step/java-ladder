package laddergame.domain;

public class Player {
    private static final int NAME_LIMIT = 5;

    private final String name;
    private Position position;

    public Player(String name, int position) {
        this(name, new Position(position));
    }

    public Player(String name, Position position) {
        if(name.length() > NAME_LIMIT){
            throw new IllegalArgumentException(String.format("플레이어의 이름을 %d자 이하로 입력해주세요.", NAME_LIMIT));
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int otherPosition) {
        return this.position.same(otherPosition);
    }

    public boolean doesNotSamePosition(int otherPosition) {
        return !isSamePosition(otherPosition);
    }
}
