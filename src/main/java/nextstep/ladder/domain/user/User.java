package nextstep.ladder.domain.user;

public class User {

    private String name;

    public User(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

}
