/**
 * Created by Jeremy on 4/29/2016.
 */
public class Account2 {
    MDA_EFSM mda = new MDA_EFSM(2,this);

    public void OPEN(int p, int y, int a) {
        mda.Open(p,y,a);
    }

    public void PIN(int x) {

        if(mda.accountData.getP().equals(String.valueOf(x))) {
                mda.CorrectPinAboveMin();
                mda.changeState("ready");
            }
        else {
            mda.IncorrectPin(2);
        }

    }

    public void DEPOSIT(int d) {
        mda.Deposit(d);
    }

    public void WITHDRAW(int w) {
        if (mda.accountData.getB() > 0) {
            mda.Withdraw(w);
        }
        else  {
            mda.NoFunds();
        }
    }

    public void BALANCE() {
        mda.Balance();
    }

    public void LOGIN(int y) {
        if (y == Integer.valueOf(mda.accountData.getY())) {
            mda.Login();
            }
        else {
            mda.IncorrectLogin();
            }
    }

    public void LOGOUT() {
        mda.Logout();
    }

    public void suspend() {
        mda.Suspend();
    }

    public void activate() {
        mda.Activate();
    }

    public void close() {
        mda.Close();
    }

}
