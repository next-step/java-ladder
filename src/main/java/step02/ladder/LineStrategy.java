package step02.ladder;

@FunctionalInterface
public interface LineStrategy {
    boolean makeLine(int height, int yPoint, boolean isBeforeLineHasLine);
}
