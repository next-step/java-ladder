package ladder.domain.strategy;

public class BuildLadder implements LadderGeneratorStrategy {

    @Override
    public Boolean isBuild() {
        return true;
    }
}
