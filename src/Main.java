import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Jeremy on 4/28/2016.
 */
public class Main {

    public static void menu1() {
        System.out.println("           MENU of Operations");
        System.out.println("          0. open(string,string,float)");
        System.out.println("          1. login(string y)");
        System.out.println("          2. pin(int)");
        System.out.println("          3. deposit(int)");
        System.out.println("          4. withdraw(int)");
        System.out.println("          5. balance()");
        System.out.println("          6. logout()");
        System.out.println("          7. lock(string x)");
        System.out.println("          8. unlock(string x)");
        System.out.println("          q. Quit the demo program");
        System.out.println("please make a selection");
    }

    public static void menu2() {
        System.out.println("          MENU of Operations" );
        System.out.println("          0. OPEN(int,int,int)" );
        System.out.println("          1. LOGIN(int)" );
        System.out.println("          2. PIN(int)" );
        System.out.println("          3. DEPOSIT(int)" );
        System.out.println("          4. WITHDRAW(int)" );
        System.out.println("          5. BALANCE()" );
        System.out.println("          6. LOGOUT()" );
        System.out.println("          7. suspend()" );
        System.out.println("          8. activate()" );
        System.out.println("          9. close()" );
        System.out.println("          q. Quit the demo program" );
    }

    public static void main(String[] args) {
        Account1 account1 = new Account1();
        Account2 account2 = new Account2();
        String input = null;
        String i = null;

        System.out.println("Which Account do you have? Press 1 for Account 1. Press 2 for Account 2");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            input = br.readLine();

        }

        catch(Exception e) {
            System.err.println("invalid format!");
        }

        if (input.equals("1")) {

            menu1();
            try {
                input = br.readLine();
            } catch (Exception e) {
                System.err.println("invalid format!");
            }



            while (!input.equals("q")) {

                if (input.equals("0")) {
                    String p = null;
                    String y = null;
                    String a = null;
                    System.out.println("type out the starting Pin, only numbers");
                    try {
                        p = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                    System.out.println("type out the account ID, only numbers");
                    try {
                        y = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                    System.out.println("type out the starting balance, only numbers");
                    try {
                        a = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                    account1.open(p, y, Float.valueOf(a));

                    menu1();
                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                } else if (input.equals("1")) {
                    System.out.println("Enter your login.");
                    String y = null;

                    try {
                        y = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                    account1.Login(y);

                    menu1();
                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                } else if (input.equals("2")) {
                    String p = null;
                    System.out.println("type out the starting Pin, only numbers");
                    try {
                        p = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                    account1.Pin(p);
                    menu1();
                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                } else if (input.equals("3")) {
                    String d = null;
                    System.out.println("type out the deposit, only numbers");
                    try {
                        d = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                    account1.Deposit(Float.valueOf(d));
                    menu1();
                    try {
                        input = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                } else if (input.equals("4")) {
                    String w = null;
                    System.out.println("type out the withdraw amount, only numbers");
                    try {
                        w = br.readLine();

                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                    account1.withdraw(Float.valueOf(w));
                    menu1();
                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                } else if (input.equals("5")) {

                    account1.balance();
                    menu1();
                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }
                } else if (input.equals("6")) {
                    account1.logout();

                } else if (input.equals("7")) {
                    System.out.println("Please enter your pin to lock");

                    String x = null;

                    try {
                        x = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                    account1.lock(x);

                    menu1();

                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                } else if (input.equals("8")) {
                    System.out.println("Please enter your pin to unlock");

                    String x = null;

                    try {
                        x = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                    account1.unlock(x);
                    menu1();
                    try {
                        input = br.readLine();
                    } catch (Exception e) {
                        System.err.println("invalid format!");
                    }

                } else if (input.equals("q")) {
                    System.out.println("BYE!");
                    System.exit(0);
                }


            }


            }
        if (input.equals("2")) {

            menu2();
            try {
                input = br.readLine();
            } catch (Exception e) {
                System.err.println("invalid format!");
            }
        }
        while (!input.equals("q")) {

            if (input.equals("0")) {
                String p = null;
                String y = null;
                String a = null;
                System.out.println("type out the starting Pin, only numbers");
                try {
                    p = br.readLine();

                }
                catch(Exception e) {
                    System.err.println("invalid format!");
                }

                System.out.println("type out the account ID, only numbers");
                try {
                    y = br.readLine();

                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }

                System.out.println("type out the starting balance, only numbers");
                try {
                    a = br.readLine();

                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }

                account2.OPEN(Integer.valueOf(p),Integer.valueOf(y),Integer.valueOf(a));

                menu2();
                try {
                    input = br.readLine();
                } catch (Exception e) {
                    System.err.println("invalid format!");
                }

            }
            else if (input.equals("1")) {
                System.out.println("Enter your login.");
                String y = null;

                try {
                    y = br.readLine();

                }
                catch(Exception e) {
                    System.err.println("invalid format!");
                }
                account2.LOGIN(Integer.valueOf(y));

                menu2();
                try {
                    input = br.readLine();
                } catch (Exception e) {
                    System.err.println("invalid format!");
                }
            }

            else if (input.equals("2")) {
                String p = null;
                System.out.println("type out the starting Pin, only numbers");
                try {
                    p = br.readLine();

                } catch (Exception e) {
                    System.err.println("invalid format!");
                }
                account2.PIN(Integer.valueOf(p));
                menu2();
                try {
                    input = br.readLine();
                } catch (Exception e) {
                    System.err.println("invalid format!");
                }

            }
            else if (input.equals("3")) {
                String d= null;
                System.out.println("type out the deposit, only numbers");
                try {
                    d = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }
                account2.DEPOSIT(Integer.valueOf(d));
                menu2();
                try {
                    input = br.readLine();

                } catch (Exception e) {
                    System.err.println("invalid format!");
                }
            }
            else if (input.equals("4")) {
                String w= null;
                System.out.println("type out the withdraw amount, only numbers");
                try {
                    w = br.readLine();

                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }
                account2.WITHDRAW(Integer.valueOf(w));
                menu2();
                try {
                    input = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }
            }
            else if (input.equals("5")) {

                account2.BALANCE();
                menu2();
                try {
                    input = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }
            }

            else if (input.equals("6")) {
                account2.LOGOUT();
                menu2();

                try {
                    input = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }
            }

            else if (input.equals("7")) {

                account2.suspend();

                menu2();

                try {
                    input = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }

            }

            else if (input.equals("8")) {

                account2.activate();
                menu2();
                try {
                    input = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }

            }
            else if (input.equals("9")) {
                account2.close();
                menu2();
                try {
                    input = br.readLine();
                }

                catch(Exception e) {
                    System.err.println("invalid format!");
                }

            }
            else if (input.equals("q")) {
                System.out.println("BYE!");
                System.exit(0);
            }
        }

        }

}
