/**
 * Created by Jeremy on 4/29/2016.
 */
public class Account1  {
    MDA_EFSM mda = new MDA_EFSM(1, this);

    Account1() {
    }

    public void open(String p, String y, float a) {
        mda.Open(p,y,a);
    }

    public void balance() {
        mda.Balance();
    }

    public void withdraw(float w) {
        if (mda.s.getClass().toString().equals("class Ready")) {
            mda.Withdraw(w);
            if (mda.accountData.getB() > 500) {
                mda.AboveMinBalance();
            } else 
                mda.WithdrawBelowMinBalance();
        }
        else if (mda.s.getClass().toString().equals("class OverDrawn")) {
            mda.Withdraw(w);
        }
    }
    public void Pin(String x) {
        if(mda.accountData.getP().equals(x)) {

            if (mda.accountData.getB() > 500) {
                mda.CorrectPinAboveMin();
            } 
            else mda.CorrectPinBelowMin();
        }
        else mda.IncorrectPin(3);
    }

    public void Deposit(float d) {
        if (mda.s.getClass().toString().equals("class Ready")) 
            mda.Deposit(d);

        else if (mda.s.getClass().toString().equals("class OverDrawn")) {
            mda.Deposit(d);
            mda.changeState("S1");
            if (mda.accountData.getB() > 500) 
                mda.AboveMinBalance();

            else {
                mda.BelowMinBalance();
            }

        }
    }

    public void Login(String y) {

        if (y.equals(mda.accountData.getY())) 
            mda.Login();
        else 
            mda.IncorrectLogin();
    }

    public void logout() {
        mda.Logout();
    }

    public void lock(String x) {
        if (mda.accountData.getP().equals(x))
            mda.Lock();
        else 
            mda.IncorrectLock();
    }

    public void unlock(String x) {
        if (mda.accountData.getP().equals(x)) {
            mda.Unlock();
            if (mda.accountData.getB() > 500) 
                mda.AboveMinBalance();
            else {
                mda.BelowMinBalance();
            }
        }
        else mda.IncorrectUnLock();
    }
}
