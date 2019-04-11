package ladder.domain;

public class Result {
    private final String name;
    private final String winning;

    public Result(String name, String winning) {
        this.name = name;
        this.winning = winning;
    }

    public boolean isNameEqual(String name) {
        return this.name.equals(name);
    }

    public String getWinning() {
        return this.winning;
    }

    @Override
    public String toString() {
        return name.trim() + " : " + winning.trim();
    }
}
