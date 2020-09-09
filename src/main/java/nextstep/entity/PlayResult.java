package nextstep.entity;

public class PlayResult {

    private final String entryName;
    private final String arrivalName;

    private PlayResult(String entryName, String arrivalName) {
        this.entryName = entryName;
        this.arrivalName = arrivalName;
    }

    public boolean isEqualEntry(String name) {
        return entryName.equals(name);
    }

    public String getArrivalName() {
        return this.arrivalName;
    }

    public static PlayResult of(String entryName, String arrivalName) {
        return new PlayResult(entryName, arrivalName);
    }
}
