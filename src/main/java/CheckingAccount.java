import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckingAccount extends CheckingCustomer implements Screen {
	
	private int index = 0;
    private int tansferindex = 0;
    private String [] AccountNo = new String [10];
    private String [] Date = new String [10];
    private double [] Balance = new double [10];
    private int [] DDeduction = new int [10];
    private int [] WDeduction = new int [10];
    PersistenceHandler handler;
    
    public CheckingAccount(int option)
    {
    	if(option == 1)
    	{
    		handler = new FileHandler();
    	}
    	else if(option == 2)
    	{
    		handler = new OracleHandler();
    	}
    }
    public void setAccountNo(String [] AccNo , int temp1)               // setting checking account no
    {
        this.AccountNo[temp1] = AccNo[temp1];
    }
    public void setCheckingClosingAccount(int flag , int index)
    {
        for(int i= index ; i < flag ; i++)
        {
            AccountNo[i] = AccountNo[i + 1];
        }
    }
    public void setDate(String [] date , int temp1)             // setting checking date
    {
        this.Date[temp1] = date[temp1];
    }
    public void setCheckingClosingDate(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            Date[i] = Date[i + 1];
        }
    }
    public void setBalance(double [] balance , int temp1)               // setting checking account balance
    {
        this.Balance[temp1] = balance[temp1];
    }
    public void setCheckingClosingBalance(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            Balance[i] = Balance[i + 1];
        }
    }
    public void setCheckingWithDrawDeductions(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            WDeduction[i] = WDeduction[i + 1];
        }
    }
    public void setCheckingDepositDeduction(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            DDeduction[i] = DDeduction[i + 1];
        }
    }
    public int verifyAccountNo(String accNo , int temp , int ind)
    {
        int temp1 = 0;
        for(int j = 0 ; j < temp ; j++)
        {
            if(accNo.equals(AccountNo[j]))
            {
                temp1 = 1;
                break;
            }
            ind++;
        }
        index = ind;
        return temp1;
    }
    public int verifyTransferAccountNo(String accno , int temp , int ind)
    {
        int temp1 = 0;
        for(int j = 0 ; j < temp ; j++)
        {
            if(accno.equals(AccountNo[j]))
            {
                temp1 = 1;
                break;
            }
            ind++;
        }

        tansferindex = ind;
        return temp1;
    }
    public void transferAmount(double am)
    {
        if(am > Balance[getCheckingIndex()])
        {
            System.out.println("\nERRORR... The Amount cannot be Transferred because the Amount is Greater than your Bank Balance");
        }
        else
        {
            Balance[getTansferIndex()] = Balance[getTansferIndex()] + am;
            Balance[getCheckingIndex()] = Balance[getCheckingIndex()] - am;
            System.out.println("\n======================================================================================================================= ");
            System.out.println("-----------------           Your Amount has Been Successfully Transferred to Desired Account          ------------------- ");
            System.out.println("------------------                         Receiver Account NO is : " + AccountNo[getTansferIndex()] + "                             -------------------------");
            System.out.println("-----------------                           Name of the Receiver is : " + CName[getTansferIndex()] + "                           -------------------------");
            System.out.println("\n========================================================================================================================");
        }

    }
    public void depositCash(double amo , int month)
    {
        if(month == 1 || month == 2)
        {
            Balance[getCheckingIndex()] = Balance[getCheckingIndex()] + amo;
        }
        else
        {
            Balance[getCheckingIndex()] = Balance[getCheckingIndex()] + amo;
            Balance[getCheckingIndex()] = Balance[getCheckingIndex()] - 10;         // deducting tax of 10 pkr
            DDeduction[getCheckingIndex()]++;                   // incrementing the value of tax in deduction array
        }
    }
    public void withDrawCash(double amo , int month)
    {
        if(Balance[getCheckingIndex()] == 0.0 )                 // checking for if the account is empty
        {
            System.out.println("\nThe Account is Empty.. Please Deposit some Cash in the Account ");
        }
        else if(amo < Balance[getCheckingIndex()])
        {
            if(month == 1 || month == 2)
            {
                Balance[getCheckingIndex()] = Balance[getCheckingIndex()] - amo;
            }
            else
            {
                Balance[getCheckingIndex()] = Balance[getCheckingIndex()] - amo;
                Balance[getCheckingIndex()] = Balance[getCheckingIndex()] - 10;
                WDeduction[getCheckingIndex()]++;                                         // incrementing the value of withdraw deduction in the array
            }
            System.out.println("\n======================================================================================================== ");
            System.out.println("------------------       The Amount Has been Successfully WithDrawn From the Account     ------------------- ");
            System.out.println("------------------             Dont Forget to Take the Cash and Reciept                  ------------------- ");
            System.out.println("------------------                         HAPPY BANKING                                --------------------");
            System.out.println("=========================================================================================================");
        }
        else if(amo > Balance[getCheckingIndex()])                      // checking account customers can withdraw more than their account balance
        {
            if(amo - Balance[getCheckingIndex()] >= 5000)               // can withdraw at most 5000 pkr
            {
                System.out.println("\nSORRY... The Amount cannot be WithDrawn, The WithDrawn Amount is Greater than the Bank Limit ");
            }
            else
            {
                Balance[getCheckingIndex()] = 0.0;
                WDeduction[getCheckingIndex()]++;
                System.out.println("\n======================================================================================================== ");
                System.out.println("------------------       The Amount Has been Successfully WithDrawn From the Account     ------------------- ");
                System.out.println("------------------             Dont Forget to Take the Cash and Reciept                  ------------------- ");
                System.out.println("------------------                         HAPPY BANKING                                --------------------");
                System.out.println("=========================================================================================================");
            }
        }

    }
    public void displayDeductions()                 // method to display deductions
    {
        int deposit = DDeduction[getCheckingIndex()] * 10;
        int withdraw = WDeduction[getCheckingIndex()] * 10;
        int sum = deposit + withdraw;
        System.out.println("\n============================================================================================================================== ");
        System.out.println("\n------------------           You Have Deposited the Cash in the Account " + DDeduction[getCheckingIndex()] + " Times, Each Deposit = 10 PKR            -----------------");
        System.out.println("------------------             You Have WithDrawn the Cash from the Account " + WDeduction[getCheckingIndex()] + " Times, Each WithDraw = 10 PKR         ------------------");
        System.out.println("------------------                        Total Amount Deducted from the Account = " + sum + "                              ------------------ ");
        System.out.println("\n===================================================================================================================================");
    }
    public void printStatement(double cwithdraw , double cdeposit)
    {
        System.out.println("\n===========================================================================================================================");
        System.out.println("------------------------------                       PRINT STATEMENT                      ---------------------------------- ");
        System.out.println("\nThe Name of the Customer is : " + CName[getCheckingIndex()]);
        System.out.println("The Postal Address of the Customer is : " + CAddress[getCheckingIndex()]);
        System.out.println("The Phone Number of the Customer is : " + CPhone[getCheckingIndex()]);
        System.out.println("The Account NO of the Customer is : " + AccountNo[getCheckingIndex()]);
        System.out.println("\n----------------------------                    TRANSACTION DETAILS                      ---------------------------------- ");
        System.out.println("\nThe Amount Recently Deposited in the Account is : " + cdeposit);
        System.out.println("The Amount Recently WithDrawn from the Account is : " + cwithdraw);

        //      GETTING SYSTEM DATE IN JAVA

        SimpleDateFormat formatter = new SimpleDateFormat("dd//MM/yyyy");
        Date date = new Date();
        System.out.println("The Date of the Transaction is :  " + formatter.format(date));

        //      GETTING SYSTEM TIME IN JAVA

        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
        Date date1 = new Date();
        System.out.println("The Time of the Transaction is :  " + formatter1.format(date1));

        System.out.println("The Remaining Balance of the Account is : " + Balance[getCheckingIndex()]);
        System.out.println("\n=======================================================================================================================");

    }
    public void checkBalance()
    {
        System.out.println("\n======================================================================================================= ");
        System.out.println("----------------------            The Account Holder Name is : " + CName[getCheckingIndex()] + "                    ------------------- ");
        System.out.println("---------------------             Your Current Account Balance is : " + Balance[getCheckingIndex()] + "                ----------------- ");
        System.out.println("-------------------                              THANK YOU                                --------------------- ");
        System.out.println("========================================================================================================== ");
    }
    public void displayAccountDetails()             // method to display account details
    {
        System.out.println("\n===========================================================================================================================");
        System.out.println("------------------------------                       BANK OWNER DETAILS                      ---------------------------------- ");
        System.out.println("\nThe Name of the Customer is : " + CName[getCheckingIndex()]);
        System.out.println("The Postal Address of the Customer is : " + CAddress[getCheckingIndex()]);
        System.out.println("The Phone Number of the Customer is : " + CPhone[getCheckingIndex()]);
        System.out.println("\n----------------------------                       BANK ACCOUNT DETAILS                      ---------------------------------- ");
        System.out.println("\nThe Account NO of the Customer is : " + AccountNo[getCheckingIndex()]);
        System.out.println("The Date of Account Creation is : " + Date[getCheckingIndex()]);
        System.out.println("The Bank Balance of the Customer is : " + Balance[getCheckingIndex()]);
        System.out.println("\n=======================================================================================================================");

    }
    public void displayAccountsDeductions(int temp)
    {

        if(AccountNo[0] == null)
        {
            System.out.println("\nSORRY... There is no Any Checking Account Created yet in our Bank ");
        }
        else
        {
            System.out.println("\n===========================================================================================================================");
            for(int i = 0 ; i < temp ; i++)
            {
                int deposit = DDeduction[i] * 10;
                int withdraw = WDeduction[i] * 10;
                int sum = deposit + withdraw;
                System.out.println("\n------------------------------                       ACCOUNT NO : " + (i  +1)  + "                        ---------------------------------- ");
                System.out.println("\nThe Name of the Customer is : " + CName[i]);
                System.out.println("The Account NO of the Customer is : " + AccountNo[i]);
                System.out.println("The Date of Account Creation is : " + Date[i]);
                System.out.println("The Bank Balance of the Customer is : " + Balance[i]);
                System.out.println("You Have Deposited the Cash in the Account " + DDeduction[i] + " Times, Each Deposit = 10 PKR ");
                System.out.println("You Have WithDrawn the Cash from the Account " + WDeduction[i] + " Times, Each WithDraw = 10 PKR ");
                System.out.println(" Total Amount Deducted from the Account = " + sum  );
                System.out.println("\n=======================================================================================================================");

            }
        }
    }
    public int getCheckingIndex()
    {
        return index;
    }
    public int getTansferIndex()
    {
        return tansferindex;
    }
    public double [] getBalance()
    {
        return Balance;
    }
    public String [] getAccountNo()
    {
        return AccountNo;
    }
    public String [] getDate()
    {
        return Date;
    }
    public void accountVerifyMessage()
    {
        System.out.println("\n----------------- Your Account has been Successfully Verified ----------------- ");
    }
    public void accountNotVerifyMessage()
    {
        System.out.println("\n----------- Your Have Login From Invalid Account or Entered Invalid Account No ------------- ");
        System.out.println("\nPlease Retry... ");
    }
    public void bankMenu()
    {
        System.out.println("\n===============================================================================" );
        System.out.println(" ---------------                     MAIN MENU             -------------------- ");
        System.out.println("===============================================================================");
        System.out.println("\n1. Deposit Cash \n2. WithDraw Cash \n3. Check Balance \n4. Print Statement \n5. Transfer Amount \n6. Display all Deductions \n7. Exit ");
    }

}
