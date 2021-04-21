package ladder.domain;

public class LineGeneratorFactory {
    public LineGenerator lineGenerator() {
        PointGenerator pointGenerator = new BasicPointGenerator();
        return new BasicLineGenerator(pointGenerator);
    }
}
