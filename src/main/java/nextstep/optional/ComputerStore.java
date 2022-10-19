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
        Optional<Computer> computerOptional = Optional.ofNullable(computer);
        if (computerOptional.isEmpty()) {
            return UNKNOWN_VERSION;
        }

        Optional<Soundcard> soundcardOptional = Optional.ofNullable(computerOptional.get().getSoundcard());
        if (soundcardOptional.isEmpty()) {
            return UNKNOWN_VERSION;
        }

        Optional<USB> usbOptional = Optional.ofNullable(soundcardOptional.get().getUsb());
        if (usbOptional.isEmpty()) {
            return UNKNOWN_VERSION;
        }

        return usbOptional.get().getVersion();
    }
}
