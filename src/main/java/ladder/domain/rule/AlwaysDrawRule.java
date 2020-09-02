package ladder.domain.rule;

public class AlwaysDrawRule implements DrawRule {
    @Override
    public boolean isDrawable() {
        return true;
    }
}
