package cc.oakk.ladder.model.line;

public class MutableConnection extends Connection {
    public MutableConnection(boolean connected) {
        super(connected);
    }

    public MutableConnection set(boolean connected) {
        this.connected = connected;
        return this;
    }
}
