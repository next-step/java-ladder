package nextstep.ladder.domain;

import java.util.Arrays;

public enum Code {
    ALL("all"), EXIT("exit");

    private final String code;

    Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static boolean contains(String input) {
        return Arrays.stream(values())
                .anyMatch(i -> i.getCode().equals(input));
    }
}
