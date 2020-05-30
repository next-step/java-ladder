package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

import java.util.Objects;
import java.util.Optional;

public class ComputerStore {
    public static final String UNKNOWN_VERSION = "UNKNOWN";

    public static String getVersion(Computer computer) {
        String version = UNKNOWN_VERSION;
        if (computer != null) {
            Soundcard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        return version;
    }

    public static String getVersionOptional(Computer computer) {
        return Optional.ofNullable(computer)
                .filter(value -> Objects.nonNull(value))
                .filter(value -> Objects.nonNull(value.getSoundcard()))
                .map(Computer::getSoundcard)
                .filter(soundcard -> Objects.nonNull(soundcard))
                .map(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse(UNKNOWN_VERSION);
    }
}
