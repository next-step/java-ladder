package ladder.domain;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5글자까지 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
