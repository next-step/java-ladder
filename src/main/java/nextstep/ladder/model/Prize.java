package nextstep.ladder.model;

public class Prize {
    private String worth;

    public Prize(String worth) {
        if (worth.isBlank()) {
            throw new IllegalArgumentException("Prize value cannot be blank");
        }
        this.worth = worth;
    }

    public String getWorth() {
        return worth;
    }
}
