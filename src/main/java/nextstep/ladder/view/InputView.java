package nextstep.ladder.view;

import nextstep.ladder.ViewUtils;
import nextstep.ladder.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PERSON_NAME_INFORMATION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INFORMATION = "최대 사다리 높이는 몇 개인가요?";
    private ViewUtils viewUtils;

    public InputView() {
        viewUtils = new ViewUtils();
    }

    public List<Person> getPersons() {
        viewUtils.printLine(PERSON_NAME_INFORMATION);
        String inputText = viewUtils.readLine();
        String[] personNames = inputText.split(",");

        return Arrays.stream(personNames)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        viewUtils.printLine(LADDER_HEIGHT_INFORMATION);
        return viewUtils.readLineToInt();
    }
}
