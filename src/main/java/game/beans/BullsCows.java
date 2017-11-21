package game.beans;

import java.io.Serializable;


public class BullsCows implements Serializable{

    private int bulls;
    private int cows;

    public BullsCows(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public BullsCows() {
    }

    public boolean isWin() {
        return bulls == 4 && cows == 0;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BullsCows bullsCows = (BullsCows) o;

        if (bulls != bullsCows.bulls) return false;
        return cows == bullsCows.cows;
    }

    @Override
    public int hashCode() {
        int result = bulls;
        result = 31 * result + cows;
        return result;
    }
}
