package generator;

public class TruePointGenerator implements PointGenerator {
    @Override
    public boolean next(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }

        return Boolean.TRUE;
    }

    @Override
    public boolean random() {
        return Boolean.TRUE;
    }
}
