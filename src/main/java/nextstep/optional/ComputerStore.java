package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

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
        Optional<Computer> optionalComputer = Optional.ofNullable(computer);

        return optionalComputer
                .map(it -> it.getSoundcard())
                .map(it -> it.getUsb())
                .map(it -> it.getVersion())
                .orElse(UNKNOWN_VERSION);
    }
}
