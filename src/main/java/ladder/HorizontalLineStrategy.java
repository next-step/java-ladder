package ladder;

@FunctionalInterface
public interface HorizontalLineStrategy {
    boolean drawLine(final int left, final int right, final Boolean[][] points);
}
