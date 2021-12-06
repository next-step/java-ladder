package nextstep.ladder.domain;

public class StringAsHeight {

    private final String number;

    public StringAsHeight(String number) {
        this.number = number;
    }

    public Height height() {
        return new Height(intValue());
    }

    private int intValue() {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력할 수 있습니다.");
        }
    }

}
