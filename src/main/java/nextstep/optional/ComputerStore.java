package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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
        AtomicReference<String> version = new AtomicReference<>(UNKNOWN_VERSION);
        Optional.ofNullable(computer)
                .filter(presentComputer -> presentComputer.getSoundcard() != null)
                .filter(presentComputer -> presentComputer.getSoundcard().getUsb() != null)
                .filter(presentComputer -> presentComputer.getSoundcard().getUsb().getVersion() != null)
                .ifPresent(presentComputer -> version.set(presentComputer.getSoundcard().getUsb().getVersion()));

        return version.get();
    }
}
