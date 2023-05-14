package laddergame.domain.line;

public enum LineStatus {
    CONNECTION("연결"),
    DETACHMENT("분리");

    private String status;

    private static final int TARGET_NUMBER = 1;

    LineStatus(final String status) {
        this.status = status;
    }

    public static LineStatus of(int number){
        return number == TARGET_NUMBER ? CONNECTION : DETACHMENT;
    }
}