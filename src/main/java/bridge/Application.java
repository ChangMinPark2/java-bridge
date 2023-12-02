package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMaker;
import bridge.util.Validator;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        bridgeController.gameStart();

    }
}
