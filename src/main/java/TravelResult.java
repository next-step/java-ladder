public class TravelResult {
    private final String playerName;
    private final String result;

    public TravelResult(String playerName, String result) {
        this.playerName = playerName;
        this.result = result;
    }

    @Override
    public String toString() {
        return this.playerName + " : " + this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelResult that = (TravelResult) o;

        return this.result.equals(that.result);
    }
}
