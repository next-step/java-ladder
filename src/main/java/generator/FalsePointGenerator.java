package generator;

public class FalsePointGenerator implements PointGenerator {
    @Override
    public boolean next(boolean previousPoint) {
        return Boolean.FALSE;
    }

    @Override
    public boolean random() {
        return Boolean.FALSE;
    }
}
