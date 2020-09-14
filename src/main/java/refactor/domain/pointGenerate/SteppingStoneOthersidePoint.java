package refactor.domain.pointGenerate;

public class SteppingStoneOthersidePoint implements PointStrategy {

    boolean first = false;

    @Override
    public boolean generatePoint() {
        first = !first;
        return !first;
    }
}
