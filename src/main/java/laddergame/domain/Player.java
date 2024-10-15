package laddergame.domain;

public class Player {
    private final String name;

    public Player(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("플레이어의 이름을 5자 이하로 입력해주세요.");
        }
        this.name = name;
    }
}
