package nextstep.ladder.doman;

public class ParticipantName {

    private final String name;

    public ParticipantName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format("이름은 최대 5글자까지 가능합니다. 입력된 이름 : %s", name));
        }
    }
}
