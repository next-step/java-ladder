package nextstep.ladder.ui;

import nextstep.ladder.doamin.ExecutionResult;
import nextstep.ladder.doamin.People;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.InputUtils;
import nextstep.ladder.utils.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Integer MINIMUM_HEIGHT_SIZE = 1;
    private static final Integer MINIMUM_PERSON_SIZE = 2;

    public People inputPersonName() {
        String personNames = InputUtils.input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<Person> people = Arrays.stream(personNames.split(DELIMITER))
                .map(Person::from)
                .collect(Collectors.toList());

        Preconditions.checkMinimumSize(people.size(), MINIMUM_PERSON_SIZE,
                                       String.format("사람 수는 %s 이상 이어야 합니다.", MINIMUM_PERSON_SIZE));
        return People.from(people);
    }

    public ExecutionResult inputExecutionResult(People people) {
        String executionResult = InputUtils.input("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        List<String> executionResults = Arrays.stream(executionResult.split(DELIMITER))
                .filter(result -> Preconditions.checkNotNull(result, "실행 결과는 필수입니다."))
                .collect(Collectors.toList());

        Preconditions.checkSameSize(executionResults.size(), people.count(), "사람 수와 결과는 동일해야 합니다.");
        return ExecutionResult.from(executionResults);
    }

    public Integer inputHeightOfLadder() {
        Integer heightOfLadder = InputUtils.inputToInteger("최대 사다리 높이는 몇 개인가요?");

        Preconditions.checkMinimumSize(heightOfLadder, MINIMUM_HEIGHT_SIZE,
                                       String.format("사다리 높이는 %s 이상 이어야 합니다.", MINIMUM_HEIGHT_SIZE));
        return heightOfLadder;
    }

    public Person inputResultOfPerson() {
        String personName = InputUtils.input("결과를 보고 싶은 사람은?");
        Preconditions.checkString(personName, "사람 이름은 필수값입니다.");
        return Person.from(personName);
    }
}
