package nextstep.ladder.domain;

public class InputUsers {
    private static final String COMMA_DELIMITER = ",";
    private String names;

    private InputUsers(String names) {
        checkMultipleUsers(names);
        this.names = names;
    }

    public static InputUsers createInputUsers(String names) {
        return new InputUsers(names);
    }

    private void checkMultipleUsers(String names) {
        if(!names.contains(COMMA_DELIMITER)) {
            throw new IllegalArgumentException("게임 참여자는 2명 이상이어야 합니다.");
        }
    }

    public String[] splitUsers() {
        return names.split(COMMA_DELIMITER);
    }
}
