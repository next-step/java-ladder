package ladder.domain.strategy;

public class DoNotBuildLadder implements LadderGeneratorStrategy {

    @Override
    public Boolean isBuild() {
        return false;
    }

    @Override
    public Boolean isBuild(int variable) {
        return isBuild();
    }
}
