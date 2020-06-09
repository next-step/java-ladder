package ladder.domain.strategy;

public class FalseLineStrategy implements LineStrategy {

    @Override
    public boolean hasLine() {
        return false;
    }
}
