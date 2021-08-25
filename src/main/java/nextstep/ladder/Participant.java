package nextstep.ladder;

public class Participant {
    private String name;

    public Participant(String name) {
        if (!validation(name)) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 사용가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean validation(String name) {
        if (name.length() > 5) {
            return false; //Error
        }
        return true;
    }
}
