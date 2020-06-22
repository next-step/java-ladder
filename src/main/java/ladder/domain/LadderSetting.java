package ladder.domain;

public class LadderSetting {

    private final String persons;
    private final String results;
    private final int height;

    public LadderSetting(String persons, String results, int height) {
        this.persons = persons;
        this.results = results;
        this.height = height;
    }

    public String getPersons() {
        return persons;
    }

    public String getResults() {
        return results;
    }

    public int getHeight() {
        return height;
    }
}
