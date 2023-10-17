package lotto;

import java.text.DecimalFormat;

enum LottoRank {
    FIFTH(3, false, 5000),
    FORTH(4, false, 50000),
    THRID(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    NONE(0, false, 0);

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

    String returnRankInfo(int count) {
        if (match == 0) return "";
        if (isBonusMatch) return match + "개 일치, 보너스 볼 일치 (" + formatter.format(price).trim() + "원) - " + count + "개";
        return match + "개 일치 (" + formatter.format(price).trim() + "원) - " + count + "개";
    }
}
