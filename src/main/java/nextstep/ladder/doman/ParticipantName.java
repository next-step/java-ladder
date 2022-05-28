package nextstep.ladder.doman;

public class ParticipantName {
    private final int MAX_NAME_LENGTH = 5;

    private final StringBuilder stringBuilder = new StringBuilder();
    private final String name;

    public ParticipantName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 최대 5글자까지 가능합니다. 입력된 이름 : %s", name));
        }
    }

    @Override
    public String toString() {
        stringBuilder.setLength(0);

        stringBuilder.append(name);
        if (name.length() >= MAX_NAME_LENGTH) {
            stringBuilder.append(" ");
        }

        while (stringBuilder.length() <= MAX_NAME_LENGTH) {
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
