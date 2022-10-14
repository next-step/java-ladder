package ladder.domain.line;

@FunctionalInterface
public interface LineFactory {

    ILine create(int playerCount);
}
