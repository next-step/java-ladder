package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;
import nextstep.optional.OptionalComputer.OptionalSoundcard;
import nextstep.optional.OptionalComputer.OptionalUSB;

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

    public static String getVersionOptional(OptionalComputer computer) {

        return Optional.ofNullable(computer)
                .flatMap(OptionalComputer::getSoundcard)
                .flatMap(OptionalSoundcard::getUsb)
                .flatMap(OptionalUSB::getVersion)
                .orElse("UNKNOWN");
    }
}
