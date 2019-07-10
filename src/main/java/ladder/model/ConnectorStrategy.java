package ladder.model;

@FunctionalInterface
public interface ConnectorStrategy {
    Direction generateNextConnection(Direction current);
}
