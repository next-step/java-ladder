package ladder.view;

public enum QuestionType {
    PARTICIPANTS("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    MAX_LADDER_HEIGHT("최대 사다리 높이는 몇 개인가요?");

    private String question;

    QuestionType(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
}
