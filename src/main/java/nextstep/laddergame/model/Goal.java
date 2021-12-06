package nextstep.laddergame.model;

public class Goal {

    private final String value;

    public Goal(String value) {
        this.value = value.trim();
    }

    public String value() {
        return value;
    }
}
