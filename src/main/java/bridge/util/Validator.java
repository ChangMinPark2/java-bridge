package bridge.util;

public final class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private Validator() {
    }

    public static void checkNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력 값이 숫자가 아닙니다: ");
        }
    }

    public static void checkUorD(String number) {
        if (!number.equals("U") && !number.equals("D")){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void checkRorQ(String number) {
        if (!number.equals("R") && !number.equals("Q")){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void checkRangeNumber(int number){
        if (number < 3 || number > 20 ){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
