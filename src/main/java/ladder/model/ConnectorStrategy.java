package ladder.model;

@FunctionalInterface
public interface ConnectorStrategy {
    boolean generateConnection(boolean before);
}
