package ladder.domain;

public class LineFactory {
    public static Line edge(int countOfPerson) {
        return get(countOfPerson, new EdgeLine(countOfPerson));
    }

    public static Line body(int countOfPerson) {
        return get(countOfPerson, new BodyLine(countOfPerson));
    }
    
    private static Line get(int countOfPerson, Line line) {
        if (countOfPerson < 0) {
            throw new IllegalArgumentException("The number of participants is greater than zero.");
        }
        return line;
    }
}
