package ladder.domain;

@FunctionalInterface
public interface Conditional {
    Line test(People people);
}
