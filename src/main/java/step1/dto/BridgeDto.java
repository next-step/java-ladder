package step1.dto;

import step1.domain.Bridge;

public class BridgeDto {

    private final boolean isOpen;

    public BridgeDto(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public static BridgeDto from(Bridge bridge) {
        return new BridgeDto(bridge.isOpen());
    }

    public boolean isOpen() {
        return isOpen;
    }
}
