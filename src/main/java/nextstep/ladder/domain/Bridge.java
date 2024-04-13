package nextstep.ladder.domain;

public enum Bridge {
	BRIDGE(true),
	NON_BRIDGE(false);

	private final boolean isBridge;

	Bridge(final boolean isBridge) {
		this.isBridge = isBridge;
	}

	public static Bridge from(final boolean now) {
		if (BRIDGE.isBridge == now) {
			return BRIDGE;
		}
		return NON_BRIDGE;
	}

	public boolean isBridge() {
		return isBridge;
	}
}
