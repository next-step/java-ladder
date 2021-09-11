package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {
    public static final String UNKNOWN_VERSION = "UNKNOWN";

    public static String getVersion(Computer computer) {
        return Optional.ofNullable(computer)
                .flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse(UNKNOWN_VERSION);
    }

    public static String getVersionOptional(Computer computer) {
        return Optional.of(computer).map(ComputerStore::getVersion).orElse(UNKNOWN_VERSION);
    }
}
