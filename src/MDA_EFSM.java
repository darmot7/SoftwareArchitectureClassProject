/**
 * Created by Jeremy on 4/28/2016.
 */
public class MDA_EFSM {

    State s;
    State checkPin;
    State idle;
    State ready;
    State overdrawn;
    State locked;
    State S1;
    State suspend;
    int accountType;
    AccountData accountData;
    Account1 account1;
    Account2 account2;
    OP opActions;// = new OP(accountType,accountData,s);

    MDA_EFSM(int accountType, Account1 account1) {

        this.accountType = accountType;
        this.account1 = account1;
        accountData = new AccountData_1();
        opActions = new OP(accountType,accountData,s);
        s = new State(this, opActions);
        checkPin = new CheckPin(this,accountData,opActions);
        idle = new Idle(this,accountData,opActions);
        ready = new Ready(this,accountData,opActions);
        overdrawn = new OverDrawn(this,accountData,opActions);
        locked = new Locked(this,accountData,opActions);
        S1 = new S1(this,accountData,opActions);
        suspend = new Suspended(this,accountData,opActions);
    }

    MDA_EFSM(int accountType, Account2 account2) {

        this.account2 = account2;
        this.accountType = accountType;
        accountData= new AccountData_2();
        opActions = new OP(accountType,accountData,s);
        s = new State(this, opActions);
        checkPin = new CheckPin(this,accountData,opActions);
        idle = new Idle(this,accountData,opActions);
        ready = new Ready(this,accountData,opActions);
        overdrawn = new OverDrawn(this,accountData,opActions);
        locked = new Locked(this,accountData,opActions);
        S1 = new S1(this,accountData,opActions);
        suspend = new Suspended(this,accountData,opActions);
    }

     public void changeState(String state) {
         if (state.equals("checkpin")) {
             s = checkPin;
         }
         else if (state.equals("idle")) {
             s = idle;
         }

         else if (state.equals("overdrawn")) {
             s = overdrawn;
         }

         else if (state.equals("locked")) {
             s = locked;
         }

         else if (state.equals("S1")) {
             s = S1;
         }

         else if (state.equals("ready")) {
             s = ready;
         }

         else if (state.equals("suspend")) {
             s = suspend;
         }
     }

    //MDA Events
    public void Open(int p,int y, int a) {
        s.Open(p,y,a);
    }

    public void Open(String p,String y, float a) {
        s.Open(p,y,a);
    }


    public void Login() {
        s.Login();
    }

    public void IncorrectLogin() {
        s.IncorrectLogin();
    }

    public void IncorrectPin(int max) {
        s.IncorrectPin(max);
    }

    public void CorrectPinBelowMin() {
        s.CorrectPinBelowMin();
    }


    public void CorrectPinAboveMin() {
        s.CorrectPinAboveMin();
    }

    public void Deposit(float d) {
        s.Deposit(d);
    }

    public void Deposit(int d) {
        s.Deposit(d);
    }

    public void BelowMinBalance() {
       s.BelowMinBalance();
    }

    public void AboveMinBalance() {
        s.AboveMinBalance();
    }

    public void Logout() {
        s.Logout();
    }

    public void Balance() {
        s.Balance();
    }

    public void Withdraw(float w) {
        s.Withdraw(w);
    }

    public void Withdraw(int w) {
        s.Withdraw(w);
    }

    public void WithdrawBelowMinBalance() {
        s.WithdrawBelowMinBalance();
    }

    public void NoFunds() {
        s.NoFunds();
    }

    public void Lock() {
        s.Lock();
    }

    public void IncorrectLock() {
        s.IncorrectLock();
    }

    public void IncorrectUnLock() {
        s.IncorrectUnlock();
    }

    public void Unlock() {
       s.Unlock();
    }

    public void Suspend() {
        s.Suspend();
    }

    public void Activate() {
        s.Activate();
    }

    public void Close() {
        s.Close();
    }
}