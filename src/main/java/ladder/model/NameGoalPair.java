package ladder.model;

public class NameGoalPair {
	private String name;

	private String goal;

	public NameGoalPair(String name, String goal) {
		this.name = name;
		this.goal = goal;
	}

	public String toStringWithDelimiter(String delimiter){
		return String.join(delimiter, name, goal);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NameGoalPair that = (NameGoalPair) o;

		if (!name.equals(that.name)) return false;
		return goal.equals(that.goal);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + goal.hashCode();
		return result;
	}
}
