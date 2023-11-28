package nextstep.ladder.domain;

public class WidthStatus {

    public static final WidthStatus notConnected = new WidthStatus(false);
    public static final WidthStatus connected = new WidthStatus(true);

    private final boolean status;

    private WidthStatus(boolean status) {
        this.status = status;
    }

    public static WidthStatus of(boolean status) {
        return status ? connected : notConnected;
    }
}
