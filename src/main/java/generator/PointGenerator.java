package generator;

public interface PointGenerator {
    boolean isConnect(boolean previousPoint);

    boolean random();
}
