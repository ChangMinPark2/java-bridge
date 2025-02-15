package bridge.view;

import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public final class InputView {
    private InputView() {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        if (!checkReadBridgeSize(input)) return readBridgeSize();

        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        try {
            Validator.checkRorQ(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input;
    }

    private static boolean checkReadBridgeSize(String input){
        try{
            Validator.checkNumber(input);
            Validator.checkRangeNumber(Integer.parseInt(input));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
