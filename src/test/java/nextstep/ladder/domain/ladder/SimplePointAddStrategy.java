package nextstep.ladder.domain.ladder;

public class SimplePointAddStrategy implements PointAddStrategy {
    @Override
    public boolean confirmPointLocation(boolean canPlace) {
        return canPlace;
    }
}
