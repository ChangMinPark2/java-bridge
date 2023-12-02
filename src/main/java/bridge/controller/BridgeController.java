package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.UserBridgeStatus;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    public void gameStart() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame();
        UserBridgeStatus userBridgeStatus = new UserBridgeStatus();
        ing(bridge, bridgeGame, userBridgeStatus);
    }

    private void ing(Bridge bridge, BridgeGame bridgeGame, UserBridgeStatus userBridgeStatus) {
        int count = 0;
        int retryCount = 1;
        boolean isSuccess = true;

        while (count < bridge.size()) {
            String pastBridge = bridge.get(count);
            String input = checkReadMoving();
            bridgeGame.move(input, pastBridge, userBridgeStatus);

            OutputView.printMap(userBridgeStatus);

            if (bridgeGame.retry(userBridgeStatus, count)) {
                String b = InputView.readGameCommand();
                if (b.equals("Q")) {
                    isSuccess = false;
                    break;
                }
                bridgeGame.back(count, userBridgeStatus);
                retryCount++;
                count--;
            }
            count++;
        }
        OutputView.printResult(userBridgeStatus, isSuccess, retryCount);
    }

    private String checkReadMoving() {
        try {
            String inputMoving = InputView.readMoving();
            Validator.checkUorD(inputMoving);
            return inputMoving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkReadMoving();
        }
    }
}
