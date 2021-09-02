package nextstep.ladder.util;

import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.Players.*;

public class Validation {
    public static final int INPUT_ALL = -1;

    public static String isEmptyAndNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 올 수 없습니다. 값을 입력 하세요");
        }
        return input;
    }

    public static void isValidPlayers(String players) {
        String[] split = players.split(DELIMITER);
        Set<String> playerCollect = Arrays.stream(players.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toSet());
        if (split.length != playerCollect.size()) {
            throw new IllegalArgumentException("참여자 이름이 중복 되었습니다.");
        }
    }

    public static void isValidResult(Players players, Result result) {
        if (players.size() != result.size()) {
            throw new IllegalArgumentException("참여자 수에 맞게 실행 결과를 입력하세요");
        }
    }

    public static int isContainPlayer(String player, Players players) {
        if (player.equals("all")) {
            return INPUT_ALL;
        }

        if (players.isContain(player)) {
            return players.indexOf(player);
        }
        throw new IllegalArgumentException("참여자들 중 해당 이름이 없습니다.");

    }
}
