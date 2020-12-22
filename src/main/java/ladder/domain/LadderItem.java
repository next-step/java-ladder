package ladder.domain;

public enum LadderItem {
    Bar, Step, Empty;

    public boolean isStep() {
        return this.equals(Step);
    }

    public boolean isBar() {
        return this.equals(Bar);
    }
}
