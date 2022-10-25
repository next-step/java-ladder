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
        Optional<Computer> optionalComputer = Optional.ofNullable(computer);

        return optionalComputer.stream()
            .filter(ComputerStore::checkNonNullUsb)
            .map(computer1 -> computer1.getSoundcard().getUsb().getVersion())
            .findFirst()
            .orElse(UNKNOWN_VERSION);
    }

    private static boolean checkNonNullUsb(Computer computer) {
        if (computer == null) {
            return false;
        }

        Soundcard soundcard = computer.getSoundcard();
        if (soundcard == null) {
            return false;
        }

        USB usb = soundcard.getUsb();
        return usb != null;
    }
}
