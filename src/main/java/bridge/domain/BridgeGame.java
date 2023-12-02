package bridge.domain;

import bridge.util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public void move(String input, String bridge, UserBridgeStatus userBridgeStatus) {
        checkMoveUpperBridge(input, bridge, userBridgeStatus);
        checkMoveDownBridge(input, bridge, userBridgeStatus);
        checkWrongUpperBridge(input, bridge, userBridgeStatus);
        checkWrongDownBridge(input, bridge, userBridgeStatus);
    }

    private void checkMoveUpperBridge(String input, String bridge, UserBridgeStatus userBridgeStatus){
        if (input.equals("U") && bridge.equals("U")) {
            userBridgeStatus.upperBridge.add("O");
            userBridgeStatus.downBridge.add(" ");
        }
    }
    private void checkMoveDownBridge(String input, String bridge, UserBridgeStatus userBridgeStatus){
        if (input.equals("D") && bridge.equals("D")) {
            userBridgeStatus.upperBridge.add(" ");
            userBridgeStatus.downBridge.add("O");
        }
    }
    private void checkWrongUpperBridge(String input, String bridge, UserBridgeStatus userBridgeStatus){
        if (input.equals("U") && bridge.equals("D")) {
            userBridgeStatus.upperBridge.add("X");
            userBridgeStatus.downBridge.add(" ");
        }
    }
    private void checkWrongDownBridge(String input, String bridge, UserBridgeStatus userBridgeStatus){
        if (input.equals("D") && bridge.equals("U")) {
            userBridgeStatus.upperBridge.add(" ");
            userBridgeStatus.downBridge.add("X");
        }
    }
    public void back(int count, UserBridgeStatus userBridgeStatus) {
        userBridgeStatus.upperBridge.remove(count);
        userBridgeStatus.downBridge.remove(count);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(UserBridgeStatus userBridgeStatus, int count) {
        return userBridgeStatus.getUpper(count).equals("X") || userBridgeStatus.getDown(count).equals("X");
    }
}
