package step2.util;

import step2.model.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineGenerator {

	private static final Random random = new Random();

	public List<Boolean> generate(Users users){
		List<Boolean> list = new ArrayList<>();
		list.add(random.nextBoolean());
		IntStream.range(1, users.getUsersCnt() - 1)
				.forEach(i -> list.add(!list.get(i - 1) && random.nextBoolean()));
		return list;
	}
}
