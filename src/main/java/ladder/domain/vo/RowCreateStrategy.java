package ladder.domain.vo;

@FunctionalInterface
public interface RowCreateStrategy {
    boolean isPreviousBridgeExist();
}
