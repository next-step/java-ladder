package nextstep.laddergame;

public class Participant {

    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("참가자의 이름은 1자에서 5자 사이여야 합니다.");
        }

    }
}
