package ladder.model;

public class PlayerRailPair {
	private String playerName;
	private int railNumber;

	public PlayerRailPair(String playerName, int railNumber) {
		this.playerName = playerName;
		this.railNumber = railNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getRailNumber() {
		return railNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PlayerRailPair that = (PlayerRailPair) o;

		if (railNumber != that.railNumber) return false;
		return playerName.equals(that.playerName);
	}

	@Override
	public int hashCode() {
		int result = playerName.hashCode();
		result = 31 * result + railNumber;
		return result;
	}
}
