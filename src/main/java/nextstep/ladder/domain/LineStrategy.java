package nextstep.ladder.domain;

@FunctionalInterface
public interface LineStrategy {
    Line execute(int countOfUsers);
}
