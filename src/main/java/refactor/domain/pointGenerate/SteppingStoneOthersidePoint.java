package refactor.domain.pointGenerate;

public class SteppingStoneOthersidePoint implements PointStrategy {

    boolean first = false;

    @Override
    public boolean generatePoint() {
        if(!first) {
            first = true;
            return false;
        }
        return true;
    }
}
