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
        if (randomBoolean.randomBoolean() && !previousHandle.isExist()) {
            return Handle.EXIST;
        }
        return Handle.NON_EXIST;
    }

    public boolean isExist() {
        if (this.exposure.equals(EXIST.exposure)) {
            return true;
        }
        return false;

    }

    public String printHandle() {
        return this.exposure;
    }

}
