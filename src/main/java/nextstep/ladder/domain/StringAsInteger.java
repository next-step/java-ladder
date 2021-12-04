package nextstep.ladder.domain;

public class StringAsInteger {

    private final String number;

    public StringAsInteger(String number) {
        this.number = number;
    }

    public int intValue() {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력할 수 있습니다.");
        }
    }

}
