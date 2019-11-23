package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameInputView {

    private static final String NAME_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private static final String PARTICIPANT_RESULT_QUESTION = "결과를 보고 싶은 사람은?";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    private BaseView baseView = new BaseView();

    public int getHeight() {
        baseView.showText(LADDER_HEIGHT);

        return baseView.readInt();
    }

    public List<String> getNames() {
        return getTexts(NAME_QUESTION);
    }

    public String getTargetParticipant() {
        baseView.showText(PARTICIPANT_RESULT_QUESTION);
        return baseView.readLine();
    }

    public List<String> getLineResults() {
        return getTexts(RESULT_QUESTION);
    }

    public List<String> getTexts(String question) {
        baseView.showText(question);

        String[] texts = splitBy(COMMA, baseView.readLine());
        return Arrays
                .stream(texts)
                .collect(Collectors.toList());
    }

    private String[] splitBy(String regex, String text) {
        return removeBlank(text).split(regex);
    }

    private String removeBlank(String text) {
        return text.replace(BLANK, EMPTY);
    }
}
