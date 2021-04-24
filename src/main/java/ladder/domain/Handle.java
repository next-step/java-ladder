package ladder.domain;

import ladder.service.RandomBoolean;

public enum Handle {
    EXIST("------"),
    NON_EXIST("      ");

    private final String exposure;

    Handle(String exposure) {
        this.exposure = exposure;
    }

    public static Handle valueOf(Handle previousHandle, RandomBoolean randomBoolean) {
        return Handle.NON_EXIST;
    }

    public String printHandle() {
        return this.exposure;
    }

}
