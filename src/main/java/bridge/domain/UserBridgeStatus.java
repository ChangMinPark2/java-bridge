package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserBridgeStatus {
    public List<String> upperBridge = new ArrayList<>();
    public List<String> downBridge = new ArrayList<>();

    public String getUpper(int count) {
        return this.upperBridge.get(count);
    }

    public String getDown(int count) {
        return this.downBridge.get(count);
    }
}
