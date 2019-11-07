package ladder.domain;

@FunctionalInterface
public interface PointConnectPolicy {

	boolean shouldConnect();

}
