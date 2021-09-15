package nextstep.ladder.domain;

public class Participant {
	public static final int MAX_SIZE = 5;
	private final String name;

	public Participant(String name) {
		validate(name);
		this.name = name;
	}

	private void validate(String name) {
		if(name.length() > MAX_SIZE) {
			throw new IllegalArgumentException(name + "은 5자를 넘습니다.");
		}
	}

	public String name() {
		return this.name;
	}
}
