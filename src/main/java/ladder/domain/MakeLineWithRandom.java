package ladder.domain;

import java.util.Random;

public class MakeLineWithRandom implements MakeLine {

    private Random random;
    private Boolean beforeLine = false;

    public MakeLineWithRandom() {
        random = new Random();
    }

    @Override
    public Boolean createLine() {

        this.beforeLine = checkBeforeLine();
        return this.beforeLine;

    }

    private Boolean checkBeforeLine() {

        return beforeLine ? false : random.nextBoolean();

    }
}
