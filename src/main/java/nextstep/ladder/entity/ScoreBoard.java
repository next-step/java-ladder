package nextstep.ladder.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import nextstep.ladder.exception.UserException;
import nextstep.ladder.exception.UserExceptionMesssage;
import nextstep.ladder.utils.StringUtils;

public class ScoreBoard {
	private final Map<String, Prize> result = new LinkedHashMap<>();

	public ScoreBoard(Users users, PrizeResult prizeResult) {
		List<User> userList = users.getUsers();
		List<Prize> prizes = prizeResult.getPrizes();

		for (User user : userList) {
			result.put(user.getName(), prizes.get(user.getPosition()));
		}
	}

	public Prize getPrizeResultStr(String userName) {
		return Optional.ofNullable(result.get(userName))
			.orElseThrow(() -> new UserException(UserExceptionMesssage.NO_PARTICIPANT));
	}

	public String getAllResult() {
		return result.entrySet()
			.stream()
			.map(entry -> StringUtils.joining(entry.getKey(), " : ", entry.getValue().getName()))
			.collect(Collectors.joining(System.lineSeparator()));
	}
}
