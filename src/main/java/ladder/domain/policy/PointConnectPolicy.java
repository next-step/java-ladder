package ladder.domain.policy;

@FunctionalInterface
public interface PointConnectPolicy {

	boolean shouldConnect();

}
