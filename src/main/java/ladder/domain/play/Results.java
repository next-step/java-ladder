package ladder.domain.play;

public class Results {
    private final Items results;

    private Results(Items results) {
        this.results = results;
    }

    public static Results of(Items items) {
        return new Results(items);
    }

    @Override
    public String toString() {
        return results.toString();
    }
}
