package ladder.domain;

public class Count {

    private int count;

    public Count(int count) {
        this.count = count;
    }

    public boolean isCountRemaining() {
        return count > 0;
    }

    public void update(String person) {
        if (person.equals("all")) {
            count = 0;
            return;
        }
        count--;
    }
}
