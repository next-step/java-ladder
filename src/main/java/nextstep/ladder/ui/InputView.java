package nextstep.ladder.ui;

import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.InputUtils;
import nextstep.ladder.utils.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PARTICIPANT_NAME_DELIMITER = ",";
    private static final Integer MINIMUM_HEIGHT_SIZE = 1;
    private static final Integer MINIMUM_PERSON_SIZE = 2;

    public List<Person> inputParticipantOfLadder() {
        String participantNames = InputUtils.input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<Person> people = Arrays.stream(participantNames.split(PARTICIPANT_NAME_DELIMITER))
                .map(Person::from)
                .collect(Collectors.toList());

        Preconditions.checkMinimumSize(people.size(), MINIMUM_PERSON_SIZE,
                                       String.format("사람 수는 %s 이상 이어야 합니다.", MINIMUM_PERSON_SIZE));
        return people;
    }

    public Integer inputHeightOfLadder() {
        Integer heightOfLadder = InputUtils.inputToInteger("최대 사다리 높이는 몇 개인가요?");

        Preconditions.checkMinimumSize(heightOfLadder, MINIMUM_HEIGHT_SIZE,
                                       String.format("사다리 높이는 %s 이상 이어야 합니다.", MINIMUM_HEIGHT_SIZE));
        return heightOfLadder;
    }
}
