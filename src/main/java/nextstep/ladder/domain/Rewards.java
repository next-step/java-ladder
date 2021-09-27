package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {

	public static final String REGEX = ",";
	private final List<Reward> rewards;

	public Rewards(String rewards) {
		String[] names = rewards.split(REGEX);
		this.rewards = IntStream
			.range(0, names.length)
			.mapToObj(i -> new Reward(names[i], new Position(i + 1)))
			.collect(Collectors.toList());

	}

	public Reward findByPosition(Position position) {
		return this.rewards
			.stream()
			.filter(reward -> reward.match(position))
			.findFirst()
			.get();
	}

	public List<String> names() {
		return this.rewards
			.stream()
			.map(Reward::name)
			.collect(Collectors.toList());
	}
}
