package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {

    public static final String UNKNOWN_VERSION = "UNKNOWN";

    private ComputerStore() {
    }

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
                .filter(ComputerStore::isSoundCardExist)
                .filter(ComputerStore::isUsbExist)
                .map(s -> s.getSoundcard().getUsb().getVersion())
                .orElse(UNKNOWN_VERSION);
    }

    private static boolean isSoundCardExist(Computer computer) {
        return computer.getSoundcard() != null;
    }

    private static boolean isUsbExist(Computer computer) {
        return computer.getSoundcard().getUsb() != null;
    }
}
