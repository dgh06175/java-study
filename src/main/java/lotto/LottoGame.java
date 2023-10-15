package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class LottoGame {
    private static final int INVALID_MONEY = -1;
    private static final int LOTTO_PRICE = 1000;

    private Lotto winningLotto;
    private int money;
    private List<Lotto> lottoArray;

    public void play() {
        money = inputMoney();
        if (money == INVALID_MONEY) return;
        System.out.println("입력한 금액은 "+money);
        //lottoArray = new Lotto(money);
    }

    private int inputMoney() {
        String inputMoney = Console.readLine();
        try {
            return validateInputMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return INVALID_MONEY;
        }
    }

    private int validateInputMoney(String inputMoney) throws IllegalArgumentException {
        int parsedMoney;
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 돈 값을 입력했습니다.");
        }

        if (parsedMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000 미만의 값을 입력했습니다.");
        }

        return parsedMoney;
    }
}
