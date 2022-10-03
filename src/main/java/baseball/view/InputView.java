package baseball.view;

import baseball.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumber() {
        System.out.println(InputMessage.INPUT_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputRestartOrFinish() {
        System.out.println(InputMessage.INPUT_REQUEST_RESTART_MESSAGE);
        return Console.readLine();
    }
}
