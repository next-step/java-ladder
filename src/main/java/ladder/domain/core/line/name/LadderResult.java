package ladder.domain.core.line.name;

final class LadderResult extends BaseName {
    public LadderResult(String name) {
        super(name);
        verifyMaxLength();
    }
}
