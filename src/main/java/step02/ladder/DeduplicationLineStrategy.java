package step02.ladder;

import java.util.Random;

public class DeduplicationLineStrategy {

//    public boolean makeLine(LineStrategy lineStrategy) {
//        // line 자체를 받아서 여기서 중복 체크 등을 진행하게끔 하면?
//
//    }

    public boolean makeLine(boolean isBeforeLineHasLine) {
        return isHasLine(isBeforeLineHasLine);
    }

    public boolean makeFirstLine() {
        return randomCreateLine();
    }

    public boolean makeLastLine() {
        return false;
    }

    private boolean isHasLine(boolean isBeforeLineHasLine) {
        if (isBeforeLineHasLine) {
            return false;
        }
        return randomCreateLine();
    }

    private boolean randomCreateLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
