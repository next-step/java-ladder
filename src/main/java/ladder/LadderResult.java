package ladder;

public class LadderResult {
    private final LadderParticipant name;
    private final LadderResultItem item;

    public LadderResult(LadderParticipant name, LadderResultItem item) {
        this.name = name;
        this.item = item;
    }

    public LadderParticipant name() {
        return this.name;
    }

    public LadderResultItem resultItem() {
        return this.item;
    }
}
