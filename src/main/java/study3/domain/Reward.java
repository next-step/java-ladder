package study3.domain;

public class Reward {
	
	private final String reward;
	
	public Reward(String reward) {
		this.reward = reward;
	}
	public String getReward() {
		return reward;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reward == null) ? 0 : reward.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reward other = (Reward) obj;
		if (reward == null) {
			if (other.reward != null)
				return false;
		} else if (!reward.equals(other.reward))
			return false;
		return true;
	}
	
	
}
