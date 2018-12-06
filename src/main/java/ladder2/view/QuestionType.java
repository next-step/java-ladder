package ladder2.view;

public enum QuestionType {
    PARTICIPANTS("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    RESULT_ITEMS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    RESULT_PARTICIPANT("결과를 보고 싶은 사람은?"),
    MAX_LADDER_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
    LADDER_DIFFICULTY("실행할 사다리의 난이도는?");

    private String question;

    QuestionType(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
}
