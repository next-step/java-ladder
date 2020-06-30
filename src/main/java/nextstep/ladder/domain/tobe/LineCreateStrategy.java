package nextstep.ladder.domain.tobe;

public interface LineCreateStrategy {
    public Direction first();
    public Direction body();
    public Direction last();
}
