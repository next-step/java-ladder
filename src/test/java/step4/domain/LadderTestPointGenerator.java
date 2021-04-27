package step4.domain;

public class LadderTestPointGenerator extends LadderPointGenerator{

    private int count = 0;

    @Override
    public boolean generatePoint() {
        if (count++ % 2 == 0) {
            return true;
        }

        return false;
    }
}
