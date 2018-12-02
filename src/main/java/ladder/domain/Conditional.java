package ladder.domain;

@FunctionalInterface
public interface Conditional {
    LadderLine generateLine(LadderWidth width);
}
