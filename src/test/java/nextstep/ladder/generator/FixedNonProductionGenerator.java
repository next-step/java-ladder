package nextstep.ladder.generator;

public class FixedNonProductionGenerator implements PositionGenerator {
    @Override
    public boolean decideLineProduction() {
        return false;
    }
}
