package baseball;

import java.util.*;

public class Application {
    static boolean isContinue = true;

    public static void main(String[] args) {
        while (isContinue) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.startGame();
            isContinue = inputGameContinue();
        }
    }

    public static boolean inputGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를  입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        return inputInt == 1;
    }
}
