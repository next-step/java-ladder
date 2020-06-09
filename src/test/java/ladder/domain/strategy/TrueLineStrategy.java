package ladder.domain.strategy;

public class TrueLineStrategy implements LineStrategy {

    @Override
    public boolean hasLine() {
        return true;
    }
}
