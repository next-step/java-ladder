package ladder.Model;

public class AttendantName {
    private static final int LIMIT_LENGTH_OF_ATTENDANT_NAME = 5;

    private String name;

    public AttendantName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public String name() {
        return this.name;
    }

    private void validateName(String inputName) {
        if (inputName == null || inputName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (inputName.length() > LIMIT_LENGTH_OF_ATTENDANT_NAME) {
            throw new IllegalArgumentException("이름은 " + LIMIT_LENGTH_OF_ATTENDANT_NAME + "자 이하만 가능합니다. [입력값: " + inputName + "]");
        }
    }
}
