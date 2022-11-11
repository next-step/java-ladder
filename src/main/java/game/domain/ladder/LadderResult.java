package game.domain.ladder;

public class LadderResult {
    private final String person;
    private final String result;

    public LadderResult(String person, String result) {
        this.person = person;
        this.result = result;
    }

    public String person() {
        return person;
    }

    public String result() {
        return result;
    }
}
