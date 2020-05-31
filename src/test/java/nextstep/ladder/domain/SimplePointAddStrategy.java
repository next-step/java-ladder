package nextstep.ladder.domain;

public class SimplePointAddStrategy implements PointAddStrategy {
    @Override
    public boolean confirmPointLocation(boolean canPlace) {
        return canPlace;
    }
}
