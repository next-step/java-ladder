package laddergame.v2.domain;

public class Player {
    private static final int NAME_LIMIT = 5;

    private final String name;

    public Player(String name) {
        if(name.length() > NAME_LIMIT){
            throw new IllegalArgumentException(String.format("플레이어의 이름을 %d자 이하로 입력해주세요.", NAME_LIMIT));
        }
        this.name = name;
    }
}
