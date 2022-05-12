package ladder.domain.step.strategy;

public class UnCrossableStrategy implements CrossStrategy {
    public boolean isCrossable() {
        return false;
    }
}
