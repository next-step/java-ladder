package nextstep.optional;

import java.util.Optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

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
                       .map(c -> Optional.ofNullable(c.getSoundcard()))
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .map(s -> Optional.ofNullable(s.getUsb()))
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .map(USB::getVersion)
                       .orElse(UNKNOWN_VERSION);
    }
}
