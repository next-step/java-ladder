package nextstep.ladder.domain.user;

public class LadderUser {

    private String name;

    public LadderUser(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

}
