package camp.nextstep.edu.rebellion.domain.rule;

public class AlwaysDrawingRule implements DrawingRule {
    @Override
    public boolean canDraw() {
        return true;
    }
}
