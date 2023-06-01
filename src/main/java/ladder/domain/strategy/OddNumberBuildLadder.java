package ladder.domain.strategy;

public class OddNumberBuildLadder implements LadderGeneratorStrategy {

    @Override
    @Deprecated
    public Boolean isBuild() {
        throw new IllegalArgumentException();
    }

    @Override
    public Boolean isBuild(int i) {
        return i % 2 == 1;
    }
}
