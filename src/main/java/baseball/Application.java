package baseball;

import java.util.*;

public class Application {
    static boolean isContinue = true;

    public static void main(String[] args) {
        while (isContinue) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.startGame();
            isContinue = baseballGame.inputGameContinue();
        }
    }
}
