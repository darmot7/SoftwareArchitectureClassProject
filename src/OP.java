/**
 * Created by Jeremy on 4/29/2016.
 */
public class OP {

    StoreData sd;
    IncorrectIdMsg iim;
    IncorrectPinMsg ipm;
    TooManyAttemptsMsg tmam;
    DisplayMenu dm;
    MakeDeposit md;
    DisplayBalance db;
    PromptForPin pfp;
    MakeWithdraw mw;
    Penalty p;
    NoFundsMsg nfm;
    AccountData accountData;
    IncorrectUnlockMsg ium;
    IncorrectLockMsg ilm;
    State s;

    OP(int accountType, AccountData accountData, State s) {
        this.accountData = accountData;

        this.s = s;

        if (accountType == 1) {
            iim = new IncorrectIdMsg1();
            ipm = new IncorrectPinMsg1();
             tmam = new TooManyAttemptsMsg1();
             dm = new DisplayMenu1();
             md = new MakeDeposit1();
             db = new DisplayBalance1();
             pfp = new PromptForPin1();
             mw = new MakeWithdraw1();
             p = new Penalty1();
            nfm = new NoFundsMsg1();
            ium = new IncorrectUnlockMsg1();
            ilm = new IncorrectLockMsg1();
        }

        else if (accountType == 2) {
             iim = new IncorrectIdMsg2();
             ipm = new IncorrectPinMsg2();
             tmam = new TooManyAttemptsMsg2();
             dm = new DisplayMenu2();
             md = new MakeDeposit2();
             db = new DisplayBalance2();
             pfp = new PromptForPin2();
             mw = new MakeWithdraw2();
             p = new Penalty2();
            nfm = new NoFundsMsg2();
            ium = new IncorrectUnlockMsg2();
            ilm = new IncorrectLockMsg2();
        }


    }

    public void StoreData(int y, int p, int a, AccountData accountData) {
        sd = new StoreData2();
        sd = new StoreData2(y,p,a,accountData);

    }

    public void StoreData(String y, String p, float a, AccountData accountData) {
        sd = new StoreData1();
        sd.storeData1(p,y,a,accountData);
    }

    public void IncorrectIdMsg() {
        iim.message();
    }
    public void IncorrectPinMsg() {
        ipm.message();
    }
    public void TooManyAttemptsMsg() {
        tmam.message();
    }
    public void DisplayMenu() {
        dm.displayMenu();
    }
    public void MakeDeposit(float d) {
        md.deposit(d, accountData);
    }

    public void DisplayBalance() {
        db.message(accountData);
    }
    public void PromptForPin() {
        pfp.message();

    }
    public void MakeWithdraw(float w) {
        mw.withdraw(w,accountData);
    }

    public void Penalty() {
        p.penalty();
    }

    public void NoFundsMsg() {
        nfm.message();
    }

    public void IncorrectUnlockMsg() {
        ium.message();
    }

    public void IncorrectLockMsg() {
        ilm.message();
    }
}

 class StoreData  {

     StoreData() {

     }

    void storeData1(String p, String y, float a, AccountData accountData) {
        }

    void storeData2(int p, int y, int a, AccountData accountData) {}
    }

class StoreData1 extends StoreData{

    StoreData1() {
    }
    public void storeData1(String p, String y, float a, AccountData accountData) {
        accountData.setA(a);
        accountData.setY(y);
        accountData.setP(p);
    }
}

class StoreData2 extends StoreData{
    StoreData2() {}

    StoreData2(int p,int y, int a, AccountData accountData){
        accountData.setA(a);
        accountData.setY(String.valueOf(y));
        accountData.setP(String.valueOf(p));
    }
}

abstract class IncorrectIdMsg {

        public void message() {
            System.out.println("Incorrect Login");
        }
    }

class IncorrectIdMsg1 extends IncorrectIdMsg {
    IncorrectIdMsg1() {}
    public void message() {
        System.out.println("Incorrect ID");
    }

}

class IncorrectIdMsg2 extends IncorrectIdMsg {
    IncorrectIdMsg2(){}
    public void message() {
        System.out.println("Incorrect ID");
    }
}


abstract class IncorrectPinMsg {
        public void message() {
            System.out.print("Incorrect PIN!");
        }
    }

class IncorrectPinMsg1 extends IncorrectPinMsg {

    IncorrectPinMsg1() {}
    public void message() {
        System.out.println("IncorrectPinMessage");
    }
}

class IncorrectPinMsg2 extends IncorrectPinMsg {
    IncorrectPinMsg2(){}
    public void message() {
        System.out.println("IncorrectPinMessage");
    }
}

    abstract class TooManyAttemptsMsg {

    public void message() {
    }
}

class TooManyAttemptsMsg1 extends TooManyAttemptsMsg {
    TooManyAttemptsMsg1() {}
    public void message() {
        System.out.println("Too many Attempts");
    }

}

class TooManyAttemptsMsg2 extends TooManyAttemptsMsg {
    TooManyAttemptsMsg2(){}
    public void message() {
        System.out.println("Too many Attempts");
    }
}



abstract class DisplayMenu {

    public void displayMenu() {
        }

}

class DisplayMenu1 extends DisplayMenu {
    DisplayMenu1(){}
    public void displayMenu() {
        System.out.println("           MENU of Operations");
        System.out.println("          0. OPEN(int,int,int)");
        System.out.println("          1. LOGIN(int)");
        System.out.println("          2. PIN(int)");
        System.out.println("          3. DEPOSIT(int)");
        System.out.println("          4. WITHDRAW(int)");
        System.out.println("          5. BALANCE()");
        System.out.println("          6. LOGOUT()");
        System.out.println("          q. Quit the demo program");
        System.out.println("please make a selection");
    }
}

class DisplayMenu2 extends DisplayMenu {
    DisplayMenu2() {}
    public void displayMenu() {
    }
}


abstract class MakeDeposit {

    public void deposit(float d, AccountData accountData) {
        }
    }

class MakeDeposit1 extends MakeDeposit {
    MakeDeposit1(){}
    public void deposit(float d, AccountData accountData) {
        accountData.setB(accountData.getB() + d);
    }
}

class MakeDeposit2 extends MakeDeposit {
    MakeDeposit2(){}
    public void deposit(float d, AccountData accountData) {
        accountData.setB(accountData.getB() + d);
    }
}
abstract class DisplayBalance  {

    DisplayBalance() {
    }
    public void message(AccountData accountData) {

    }
}

class DisplayBalance1 extends DisplayBalance {
    DisplayBalance1(){}
    public void message(AccountData accountData) {
        System.out.format("Your Balance is: %f%n", accountData.getB());
    }

}

class DisplayBalance2 extends DisplayBalance {
    DisplayBalance2() {}
    public void message(AccountData accountData) {
        System.out.format("Your Balance is: %f%n", accountData.getB());
    }
}

    abstract class PromptForPin {
        PromptForPin() {

        }
        public void message() {
        }
    }

class PromptForPin1 extends PromptForPin {

    PromptForPin1() {
    }

    public void message() {
        System.out.println("Please enter your pin");
    }

}

class PromptForPin2 extends PromptForPin {

    PromptForPin2() {}

    public void message() {
        System.out.println("Please enter your pin");
    }
}

abstract class MakeWithdraw {
    public void withdraw(float w, AccountData accountData) {}
    }

class MakeWithdraw1 extends MakeWithdraw {
    MakeWithdraw1() {}
        public void withdraw(float w,AccountData accountData) {
            accountData.setB(accountData.getB() - w);
        }
}

class MakeWithdraw2 extends MakeWithdraw {
    MakeWithdraw2(){}
    public void withdraw(float w,AccountData accountData) {
        accountData.setA(accountData.getB() - w);
    }
}
abstract  class Penalty  {
    public void penalty() {
    }
}

class Penalty1 extends Penalty {
    Penalty1(){}
    public void penalty() {
    }
}

class Penalty2 extends Penalty {
    Penalty2(){}
    public void penalty() {
    }
}


abstract class IncorrectLockMsg  {

    public void message() {
    }

}

class IncorrectLockMsg1 extends IncorrectLockMsg {
    IncorrectLockMsg1(){}
    public void message() {
        System.out.println("Incorrect Lock Message");
    }
}

class IncorrectLockMsg2 extends IncorrectLockMsg {
    IncorrectLockMsg2(){}
    public void message() {
        System.out.println("Incorrect Lock Message");
    }
}



    abstract class IncorrectUnlockMsg {

        public void message() {}
}

class IncorrectUnlockMsg1 extends IncorrectUnlockMsg {
    IncorrectUnlockMsg1(){}
    public void message() {
        System.out.println("Incorrect Unlock");
    }

}

class IncorrectUnlockMsg2 extends IncorrectUnlockMsg {
    IncorrectUnlockMsg2(){}
    public void message() {
        System.out.println("Incorrect Unlock");
    }


}
abstract class NoFundsMsg{
    public void message() {}
    }

class NoFundsMsg1 extends NoFundsMsg {
    NoFundsMsg1(){}
    public void message() {
        System.out.println("No funds!");
    }

}

class NoFundsMsg2 extends NoFundsMsg {
    NoFundsMsg2(){}
    public void message() {
        System.out.println("No funds");
    }

}

