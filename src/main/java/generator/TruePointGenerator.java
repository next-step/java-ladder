package generator;

public class TruePointGenerator implements PointGenerator {
    @Override
    public boolean isConnect(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }

        return Boolean.TRUE;
    }
}
