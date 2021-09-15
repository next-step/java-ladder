package nextstep.ladder.domain;

public class Block {

	private final boolean isConnected;

	public Block(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public Block makeNext(boolean wantBeConnect) {
		boolean isConnected = (wantBeConnect == !this.isConnected);
		if (wantBeConnect == false) {
			isConnected = false;
		}
		return new Block(isConnected);
	}

	public boolean isConnected() {
		return this.isConnected;
	}
}
