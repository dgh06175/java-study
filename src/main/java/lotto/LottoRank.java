package lotto;

import java.text.DecimalFormat;

enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THRID(5, false, 1500000),
    FORTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int match;
    private final boolean isBonusMatch;
    private final int price;
    DecimalFormat formatter = new DecimalFormat("###, ###");

    LottoRank (int match, boolean isBonusMatch, int price) {
        this.match = match;
        this.isBonusMatch = isBonusMatch;
        this.price = price;
    }

    int getMatch() {
        return match;
    }

    boolean getIsBonusMatch() {
        return isBonusMatch;
    }

    int getPrice() {
        return price;
    }

    void printRankInfo() {
        System.out.println(match + "개 일치 (" + formatter.format(price) + "원)");
    }
}
