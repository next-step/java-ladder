package nextstep.ladder;

public class Player {
    private String name;

    public Player(String name) {
        valid(name);
        this.name = name;
    }

    private void valid(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자르 넘을 수 없습니다.");
        }
    }

}
