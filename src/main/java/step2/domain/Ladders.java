package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladders {
	private List<Ladder> ladders;

	public Ladders(List<Ladder> ladders) {
		this.ladders = new ArrayList<>(ladders);
	}

	public static Ladders createLadders(List<User> users) {
		return new Ladders(
				users.stream()
						.map(Ladder::new)
						.collect(Collectors.toList())
		);
	}


}
