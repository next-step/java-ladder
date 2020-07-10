package generator;

public interface PointGenerator {
    boolean next(boolean previousPoint);

    boolean random();
}
