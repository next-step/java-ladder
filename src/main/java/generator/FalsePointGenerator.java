package generator;

public class FalsePointGenerator implements PointGenerator {
    @Override
    public boolean random() {
        return Boolean.FALSE;
    }
}
