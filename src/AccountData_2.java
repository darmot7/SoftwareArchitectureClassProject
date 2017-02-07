/**
 * Created by Jeremy on 4/28/2016.
 */
public class AccountData_2 extends AccountData{

    int p;
    int y;
    int attempts=0;
    float b;
    int w;
    int accountType = 2;

    AccountData_2() {

    }

    public float getA() {
        return a;
    }

    public String getY() {
        return Integer.toString(y);
    }

    public String getW() {return Float.toString(w);}
    public String getP() {
        return Integer.toString(p);
    }

    public void setA(float a) {
        this.b = a;
    }

    public void setP(String p) {
        this.p = Integer.valueOf(p);
    }

    public void setY(String y) {
        this.y = Integer.valueOf(y);
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

    public int getAccountType() {

        return accountType;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }


    public boolean checkPin2(String p) {
        if (Integer.valueOf(p) == this.p) 
            return true;

        return false;
    }


}
