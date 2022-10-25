package nextstep.ladder;

public class TwoRepeatGenerator implements BooleanGenerator {
    private int number = 0;
    @Override
    public boolean generate() {
        if (number < 2) {
            number++;
            return false;
        } else if (number < 4) {
            number++;
            return true;
        } else {
            number = 1;
            return false;
        }
    }
}
