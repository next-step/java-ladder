package nextstep.ladder;

import java.util.Objects;

public class Validation {
    private static final int LETTER_LIMIT = 5;
    private static final String SPACE = " ";

    public static String lengthValidation(String n){
        if (n.length() > 5) {
            throw new IllegalArgumentException(String.format("이름은 %d글자 이상 넣을 수 없습니다.", LETTER_LIMIT));
        }

        return fitLength(n);
    }

    private static String fitLength(String n) {

        if(n.length() < LETTER_LIMIT) {
            n = fitLength(SPACE.concat(n));
        }

        return n;
    }

    public static String inputValidation(String inputStr) {
        if (Objects.isNull(inputStr) || inputStr.equals("")) {
            throw new IllegalArgumentException("이름을 공백으로 할 수 없습니다.");
        }
        return inputStr;
    }
}
