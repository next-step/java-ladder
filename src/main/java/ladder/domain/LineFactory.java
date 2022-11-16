package ladder.domain;

public class LineFactory {
    public static Line edge(final int countOfPerson) {
        return get(countOfPerson, new EdgeLine(countOfPerson));
    }

    public static Line body(final int countOfPerson) {
        return get(countOfPerson, new BodyLine(countOfPerson));
    }
    
    private static Line get(final int countOfPerson, final Line line) {
        if (countOfPerson < 0) {
            throw new IllegalArgumentException("The number of participants is greater than zero.");
        }
        return line;
    }
}
