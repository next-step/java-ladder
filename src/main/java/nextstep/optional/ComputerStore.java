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
        return Optional.ofNullable(computer)
                .filter(ComputerStore::isNotNullUsb)
                .map(c -> c.getSoundcard().getUsb().getVersion())
                .orElse(ComputerStore.UNKNOWN_VERSION);
    }

    private static boolean isNotNullUsb(Computer computer) {
        return computer.getSoundcard() != null && computer.getSoundcard().getUsb() != null;
    }
}
