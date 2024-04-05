package nextstep.step2;

public class Participant {

    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Participant(String name) {
        validation(name);
        this.name = name;
    }

    private void validation(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름에는 null과 공백이 올 수 없고 5자 이하로 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
