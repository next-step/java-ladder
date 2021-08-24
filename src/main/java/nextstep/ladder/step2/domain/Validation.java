package nextstep.ladder.step2.domain;

public class Validation {
    public static String isEmptyAndNull(String input) {
        if (input == null || input.isEmpty() || input.equals(" ")) {
            throw new IllegalArgumentException("빈 값은 올 수 없습니다. 값을 입력 하세요");
        }
        return input;
    }
}
