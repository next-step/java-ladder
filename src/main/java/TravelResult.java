public class TravelResult {
    private final String playerName;
    private final String resultName;
    private final Pos pos;

    public TravelResult(String playerName, String resultName, Pos pos) {
        this.playerName = playerName;
        this.resultName = resultName;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return this.playerName + " : " + this.resultName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelResult that = (TravelResult) o;

        return this.pos == that.pos;
    }
}
