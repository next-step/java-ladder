package ladder.domain;

public class Participant {
    private String name;

    private Participant(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("참여할 사람의 이름은 최대 5글자까지만 입력가능합니다.");
        }
        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(name);
    }
}
