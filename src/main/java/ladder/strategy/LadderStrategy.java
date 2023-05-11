package ladder.strategy;

public interface LadderStrategy {

    boolean firstLine();
    boolean nextLine(boolean previous);
}
