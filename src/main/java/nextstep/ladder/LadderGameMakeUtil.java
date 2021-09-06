package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Person;
import nextstep.ladder.model.Reward;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderGameMakeUtil {
    private static final String INPUT_SEPARATOR = ",";

    public static List<Person> makePeople(String input) {
        if ("".equals(input.trim())) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }

        return Arrays.stream(input.split(INPUT_SEPARATOR))
                .map((name) -> new Person(name))
                .collect(Collectors.toList());
    }

    public static List<Reward> makeRewards(String input) {
        if ("".equals(input.trim())) {
            throw new IllegalArgumentException("결과 값이 입력되지 않았습니다.");
        }

        return Arrays.stream(input.split(INPUT_SEPARATOR))
                .map((reward) -> new Reward(reward))
                .collect(Collectors.toList());
    }

    private static final Random RANDOM = new Random();

    public static Ladder makeLadder(int numberOfPeople, int height) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException("참가자가 존재하지 않습니다.");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("사다리 길이가 유효하지 않습니다.");
        }

        return new Ladder(numberOfPeople, height);
    }
}
