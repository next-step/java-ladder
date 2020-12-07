package ladder.domain;

public class SampleShufflePattern implements HowToConnect {

    private int idx = 0;

    public SampleShufflePattern() {
    }

    @Override
    public boolean needToConnect(Boolean leftSideCondition) {
        idx += 1;
        return isEven(idx);
    }

    private boolean isEven(int index) {
        return index % 2 == 0;
    }
}
