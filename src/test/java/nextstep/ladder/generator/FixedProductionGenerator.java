package nextstep.ladder.generator;

public class FixedProductionGenerator implements PositionGenerator {
    @Override
    public boolean decideLineProduction() {
        return true;
    }
}
