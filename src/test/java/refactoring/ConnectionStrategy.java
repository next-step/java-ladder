package refactoring;

public class ConnectionStrategy implements LineConnection {

    @Override
    public LineStatus toLineStatus() {
        LineStatus currentStatus = LineStatus.of(RandomGenerator.create());
        return StatusFilter.filter(currentStatus);
    }
}


