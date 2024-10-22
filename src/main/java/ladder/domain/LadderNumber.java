package ladder.domain;

public class LadderNumber {
    private final static int MIN_NUMBER = 1;
    private final static String NUMBER_ERROR_MESSAGE = "높이는 2이상이어야 합니다.";
    private final int number;

    public LadderNumber(int number) {
        this.number = validate(number);
    }

    public int validate(int number) {
        if(number <= MIN_NUMBER) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}
