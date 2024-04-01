package nextstep.step2;

public class AlwaysFalsePointGenerator implements PointGenerator{

    @Override
    public boolean generatePoint() {
        return false;
    }
}
