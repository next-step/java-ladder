package nextstep.ladder.domain;

public class LinePart {

    private boolean isConnected;

    public LinePart() {
    }

    public void connect() {
        this.isConnected = true;
    }

    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public String toString() {
        return "{" +
            "" + isConnected +
            '}';
    }

}
