package nextstep.ladder.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import nextstep.ladder.utils.StringUtils;

public class ScoreBoard {
	private final Map<String, String> result = new LinkedHashMap<>();

	public ScoreBoard(Users users, PrizeResult prizeResult) {
		List<User> userList = users.getUsers();
		List<Prize> prizes = prizeResult.getPrizes();

		for (User user : userList) {
			result.put(user.getName(), prizes.get(user.getPosition().getPosition()).getName());
		}

		String all = result.entrySet()
			.stream()
			.map(entry -> StringUtils.joining(entry.getKey(), " : ", entry.getValue()))
			.collect(Collectors.joining("\n"));

		result.put("all", all);
	}

	public String getPrizeResultStr(String userName) {
		return Optional.ofNullable(result.get(userName))
			.orElseGet(() -> "참가한 사용자가아닙니다.");
	}
}
