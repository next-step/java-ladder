package ladder.domain;

public class LineGeneratorFactory {
    public LineGeneratorInterface lineGenerator() {
        PointGeneratorInterface pointGeneratorInterface = new PointGeneratorImpl();
        return new LineGeneratorImpl(pointGeneratorInterface);
    }
}
