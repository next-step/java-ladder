package nextstep.ladder.domain;

@FunctionalInterface
public interface LineCreator {
    Line create(int countOfPerson);
}
