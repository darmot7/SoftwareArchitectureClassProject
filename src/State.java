import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Jeremy on 4/28/2016.
 */

 public class State {
     int accountType;
     OP opActions;
     MDA_EFSM mda;
    int attempts = 0;
    AccountData accountData;

    State () {
    }

    State(MDA_EFSM mda, OP opActions) {
        this.mda = mda;
        this.opActions = opActions;
    }

    public void Login() {throw new Error("function not possible in this state");}
    public void IncorrectPin(int max) {throw new Error("function not possible in this state");}
    public void CorrectPinBelowMin() {throw new Error("function not possible in this state");}
    public void CorrectPinAboveMin() {throw new Error("function not possible in this state");}
    public void Deposit(float d) {throw new Error("function not possible in this state");}
    public void Deposit(int d) {throw new Error("function not possible in this state");}
    public void BelowMinBalance() {throw new Error("function not possible in this state");}
    public void AboveMinBalance() {throw new Error("function not possible in this state");}
    public void Logout() {throw new Error("function not possible in this state");}
    public void Balance() {throw new Error("function not possible in this state");}
    public void Withdraw(float w) {throw new Error("function not possible in this state");}
    public void Withdraw(int w) {throw new Error("function not possible in this state");}
    public void WithdrawBelowMinBalance() {throw new Error("function not possible in this state");}
    public void NoFunds() {throw new Error("function not possible in this state");}
    public void Lock() {throw new Error("function not possible in this state");}
    public void IncorrectLogin() {throw new Error("function not possible in this state");}
    public void Unlock() {throw new Error("function not possible in this state");}
    public void IncorrectLock() {throw new Error("function not possible in this state");}
    public void IncorrectUnlock() {throw new Error("function not possible in this state");}
    public void Suspend() {throw new Error("function not possible in this state");}
    public void Activate() {throw new Error("function not possible in this state");}
    public void Close() {throw new Error("function not possible in this state");}

    public void Open(int p,int y, int a) {

        opActions.StoreData(p,y,a, mda.accountData);
        mda.changeState("idle");

    }
    public void Open(String p,String y, float a) {

        opActions.StoreData(p,y,a,mda.accountData);
        mda.changeState("idle");
    }
}

    class Idle extends State{
        OP opActions;
        AccountData accountData;
        Idle(MDA_EFSM mda, AccountData accountData, OP opActions) {
            this.mda = mda;
            this.accountData = accountData;
            this.opActions = opActions;
        }

        public void Login() {
            opActions.PromptForPin();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String pin = null;
            try {
                pin = br.readLine();
            }
            catch(Exception e) {
                System.err.println("invalid format!");
            }
            mda.changeState("checkpin");
            if (mda.accountType == 1)
            mda.account1.Pin(pin);
            else if (mda.accountType == 2) mda.account2.PIN(Integer.valueOf(pin));
        }
        public void IncorrectLogin() {
            opActions.IncorrectIdMsg();
        }

    }

    class CheckPin extends State{
        OP opActions;
        CheckPin(MDA_EFSM mda, AccountData accountData, OP opActions) {
            this.mda = mda;
            this.opActions = opActions;
        }

        public void IncorrectPin(int max) {
            opActions.IncorrectPinMsg();
            mda.accountData.setAttempts(mda.accountData.getAttempts() + 1);
            if (mda.accountData.getAttempts() == max) {
                mda.changeState("idle");
                opActions.TooManyAttemptsMsg();
                System.exit(0);
            }
        }

        public void Logout() {
            mda.changeState("idle");
        }
        public  void CorrectPinAboveMin() {
            System.out.println("Correct Pin Above Min");
            opActions.DisplayMenu();
            mda.changeState("ready");
        }
        public  void CorrectPinBelowMin() {
            mda.changeState("overdrawn");
            opActions.DisplayMenu();

        }
    }

    class Ready extends State{
        public void Logout() {
            mda.changeState("idle");
        }
        OP opActions;
        Ready(MDA_EFSM mda, AccountData accountData,OP opActions) {
            this.mda = mda;
            this.opActions = opActions;

        }
        public void Deposit(int d) {
            opActions.MakeDeposit(d);
        }
        public void Deposit(float d) {
            opActions.MakeDeposit(d);
        }
        public void IncorrectLock() {
            opActions.IncorrectLockMsg();
        }
        public void Balance() {
            opActions.DisplayBalance();
        }
        public void NoFunds() {
            opActions.NoFundsMsg();
        }
        public void Withdraw(float w) {
            opActions.MakeWithdraw(w);
            if (mda.accountType == 1) mda.changeState("S1");
            else mda.changeState("ready");
        }

        public void Withdraw(int w) {
            opActions.MakeWithdraw(w);
            if (mda.accountType == 1) mda.changeState("S1");
            else if (mda.accountType == 2) mda.changeState("ready");
        }
        public void Lock() {
            System.out.println("System is locked");
            mda.changeState("locked");
        }
        public void Suspend() {
            System.out.println("Account is suspended");
            mda.changeState("suspend");
        }
    }


    class S1 extends State{
        OP opActions;
        S1(MDA_EFSM mda, AccountData accountData,OP opActions) {
            this.mda = mda;
            this.opActions = opActions;
        }
        public  void AboveMinBalance() {
            mda.changeState("ready");
        }

        public  void WithdrawBelowMinBalance() {
            System.out.println("WithdrawBelowMinBalance");
            opActions.Penalty();
            mda.changeState("overdrawn");
        }
        public void BelowMinBalance() {
            mda.changeState("overdrawn");
        }
    }

    class OverDrawn extends State{

        OverDrawn(MDA_EFSM mda, AccountData accountData,OP opActions) {
            this.mda = mda;
            this.opActions = opActions;
        }
        public void Withdraw(float w) {
            opActions.NoFundsMsg();
        }
        public  void Balance() {
            opActions.DisplayBalance();
        }
        public void Lock() {
            System.out.println("System is locked");
            mda.changeState("locked");
        }
        public  void Deposit(float d) {
            opActions.MakeDeposit(d);
        }
        public  void Deposit(int d) {
            opActions.MakeDeposit(d);
        }
    }

    class Locked extends State{
        OP opActions;
        Locked(MDA_EFSM mda, AccountData accountData, OP opActions) {
            this.mda = mda;
            this.opActions = opActions;
        }
        public void IncorrectUnlock() {
            super.opActions.IncorrectUnlockMsg();
        }

        public  void Unlock() {
            mda.changeState("S1");
        }
    }

    class Suspended extends State{
        OP opActions;
        Suspended(MDA_EFSM mda, AccountData accountData, OP opActions) {
            this.opActions = opActions;
            this.mda = mda;
        }
        public  void Activate() {
            mda.changeState("ready");
            System.out.println("System is active " + mda.s.getClass().toString());
        }
        public  void Close() {
            System.exit(0);
        }
    }

