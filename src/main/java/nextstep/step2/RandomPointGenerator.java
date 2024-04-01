package nextstep.step2;

public class RandomPointGenerator implements PointGenerator{

    @Override
    public boolean generatePoint() {
        return Math.random() < 0.5;
    }
}
