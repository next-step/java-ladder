package ladder.domain.core.line.name;

final class LadderResult extends Name {
    public LadderResult(String name) {
        super(name);
        verifyMaxLength();
    }
}
