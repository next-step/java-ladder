package step2.enums;

public enum ResultMessage {

    RESULT("실행결과"),
    CREATE_LADDER("-----|"),
    NO_LADDER("     |");

    ResultMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }

}
