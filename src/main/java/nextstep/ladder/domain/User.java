package nextstep.ladder.domain;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private int position;


    public User(String name, int position) {
        validateName(name);

        this.name = name;
        this.position = position;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자까지 가능합니다.");
        }
        if (name.equals("all")) {
            throw new IllegalArgumentException("all은 부적절한 이름입니다.");
        }
    }

    public User rideLadder(Ladder ladder) {
        int lastPosition = ladder.findLastPosition(position);
        return new User(name, lastPosition);
    }
}
