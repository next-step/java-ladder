package ladder.domain.factory;

@FunctionalInterface
public interface LineFactory {

    ILine create(int playerCount);
}
