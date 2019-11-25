package nextstep.ladder.view;

public class LadderGameInputView {

    private static final String NAME_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PARTICIPANT_RESULT_QUESTION = "결과를 보고 싶은 사람은?";


    private BaseView baseView = new BaseView();

    public int getHeight() {
        baseView.showText(LADDER_HEIGHT);

        return baseView.readInt();
    }

    public String getNames() {
        baseView.showText(NAME_QUESTION);
        return baseView.readLine();
    }

    public String getTargetParticipant() {
        baseView.showText(PARTICIPANT_RESULT_QUESTION);
        return baseView.readLine();
    }

    public String getLineResults() {
        baseView.showText(RESULT_QUESTION);
        return baseView.readLine();
    }
}
