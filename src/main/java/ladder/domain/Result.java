package ladder.domain;

public class Result {
    private final String name;
    private final String prize;

    public Result(String name, String prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public String getPrize() {
        return prize;
    }
}
