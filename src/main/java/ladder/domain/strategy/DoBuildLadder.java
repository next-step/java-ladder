package ladder.domain.strategy;

public class DoBuildLadder implements LadderGeneratorStrategy {

    @Override
    public Boolean isBuild() {
        return true;
    }

    @Override
    public Boolean isBuild(int variable) {
        return isBuild();
    }
}
