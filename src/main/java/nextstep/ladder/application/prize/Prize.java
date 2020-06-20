package nextstep.ladder.application.prize;

public class Prize {
	private final String name;

	private Prize(String name) {
		this.name = name;
	}

	public static Prize ofName(String name) {
		return new Prize(name);
	}

	public String getName() {
		return name;
	}
}
