package nextstep.ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        if (name.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만으로 구성된 이름은 허용되지 않습니다: " + name);
        }

        if (!name.matches("[a-zA-Z0-9가-힣]+")) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 포함되어 있습니다: " + name);
        }
    }

    public String getName() {
        return name;
    }
}
