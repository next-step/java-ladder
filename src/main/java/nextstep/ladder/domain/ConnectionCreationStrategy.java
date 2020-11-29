package nextstep.ladder.domain;

@FunctionalInterface
interface ConnectionCreationStrategy {
    boolean isAble();
}
