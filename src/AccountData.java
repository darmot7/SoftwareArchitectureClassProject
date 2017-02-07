/**
 * Created by Jeremy on 4/28/2016.
 */
public class AccountData {

    String y;
    float w;
    float a;
    String p;
    float b;
    int attempts;
    int accountType = 0;
    float d;


    public String getY() {
        return y;
    }

    public void setY(String y) {

    }

    public void setY(int y) {

    }


    public String getW() {
        return Float.toString(w);
    }

    public void setW(float w) {this.w = w;
    }

    public float getD() {
        return d;
    }


    public void setD(float d) {

        this.d = d;
    }
    public float getA() {
        return a;
    }

    public String getP() {
        return p;
    }


    public void setP(String p) {
        this.p = p;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }


    public void setB(float b) {
        this.b = b;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }


    public boolean checkPin(String p) {
        if (this.p.equals(p)) return true;

        return false;
    }

    public int getAccountType() {

        return accountType;
    }
}

