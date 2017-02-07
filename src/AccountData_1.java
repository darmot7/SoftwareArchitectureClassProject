/**
 * Created by Jeremy on 4/28/2016.
 */

public class AccountData_1 extends AccountData{
    float b = 0; //balance
    String p; //pin
    String y = "1234"; // unique id

    float w; // withdraw amount
    int attempts =0; //number of attempts

    int accountType = 1; // account type
    float d; // deposit amount

    AccountData_1() {

    }

    public float getD() {
        return d;
    }

    public String gettempY() {
        return y;
    }

    public String getY() {
        return y;
    }

    public String getW() {
        return Float.toString(w);
    }

    public float getA() {
        return a;
    }

    public String getP() {
        return p;
    }

    public void setD(float d) {

        this.d = d;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setP(String p) {
        this.p = p;
    }

    public void setA(float a) {
        this.b = a;
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

    public int getAccountType() {
        return accountType;
    }


}
