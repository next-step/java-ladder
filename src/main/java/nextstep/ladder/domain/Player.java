package nextstep.ladder.domain;

public class Player {
    private String name;

    public Player(String name) {
        validNameLength(name);
        this.name = name;
    }

    private void validNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자르 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }


}
