package ladder.domain;

public class Player {

    private final String name;

    public Player(String name){
        validlength(name);
        this.name = name;
    }

    private void validlength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("참여자의 이름은 5글자를 넘을 수 없습니다. 에러이름 : " + name);
        }
    }
}
