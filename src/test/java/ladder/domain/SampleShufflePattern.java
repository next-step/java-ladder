package ladder.domain;

public class SampleShufflePattern implements ConnectionMode {

    private int idx = 0;

    public SampleShufflePattern() {
    }

    @Override
    public boolean generateConnection() {
        idx += 1;
        return isEven(idx);
    }

    private boolean isEven(int index) {
        return index % 2 == 0;
    }
}
