package domain;

public class Bridge {

    private final boolean value;

    public Bridge(boolean value) {
        this.value = value;
    }

    public boolean has() {
        return this.value;
    }
}
