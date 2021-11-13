
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SavingsAccount extends SavingsCustomer implements Screen {
	
	private int index = 0;
    private int transferindex = 0;
    double interestrate = 1.0;
    private String [] AccountNo = new String [5];
    private double [] Balance = new double [5];
    private String [] Date = new String [5];
    private double [] ZDeduction = new double [5];
    PersistenceHandler handler;
    
    public SavingsAccount(int option)
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
    public void setSavingsClosingAccount(int flag , int index)
    {
        for(int i= index ; i < flag ; i++)
        {
            AccountNo[i] = AccountNo[i + 1];
        }
    }
    public void setDate(String [] date , int temp1)
    {
        this.Date[temp1] = date[temp1];
    }
    public void setSavingsClosingDate(int flag , int index)
    {
        for(int i= index ; i < flag ; i++)
        {
            Date[i] = Date[i + 1];
        }
    }
    public void setBalance(double [] balance , int temp1)
    {
        this.Balance[temp1] = balance[temp1];
    }
    public void setSavingsClosingBalance(int flag , int index)
    {
        for(int i= index ; i < flag ; i++)
        {
            Balance[i] = Balance[i + 1];
        }
    }
    public void setInterestRate(double interest)
    {
        this.interestrate = interest;
    }
    public String [] getAccountNo()
    {
        return AccountNo;
    }
    public int verifyAccountNo(String accNo , int temp1 , int ind)
    {
        int temp = 0;
        for(int i = 0 ; i < temp1  ; i++)
        {
            if(accNo.equals(AccountNo[i]))          // Verifying Savings Account
            {
                temp = 1;
                break;
            }
            ind++;
        }
        index = ind;
        return temp;
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

        transferindex = ind; 
        return temp1;
    }
    public void depositCash(double amo)
    {
        Balance[getSavingsIndex()] = Balance[getSavingsIndex()] + amo;

    }
    public void setSavingsZakatDeduction(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            ZDeduction[i] = ZDeduction[i + 1];
        }
    }
    public void withDrawCash(double amo)
    {
        if(Balance[getSavingsIndex()] == 0.0)
        {
            System.out.println("\nThe Account is Empty.. Please Deposit some Cash in the Account  ");
        }
        else if(amo > Balance[getSavingsIndex()])
        {
            System.out.println("\nSORRY... You Cannot WithDraw more than Your Account Balance ");

        }
        else if(amo < Balance[getSavingsIndex()])
        {
            Balance[getSavingsIndex()] = Balance[getSavingsIndex()] - amo;
            System.out.println("\n======================================================================================================== ");
            System.out.println("------------------       The Amount Has been Successfully WithDrawn From the Account     ------------------- ");
            System.out.println("------------------             Dont Forget to Take the Cash and Reciept                  ------------------- ");
            System.out.println("------------------                         HAPPY BANKING                                --------------------");
            System.out.println("=========================================================================================================");
        }
    }
    public void displayAccountDetails()
    {
        System.out.println("\n===========================================================================================================================");
        System.out.println("------------------------------                       BANK OWNER DETAILS                      ---------------------------------- ");
        System.out.println("\nThe Name of the Customer is : " + SName[getSavingsIndex()]);
        System.out.println("The Postal Address of the Customer is : " + SAddress[getSavingsIndex()]);
        System.out.println("The Phone Number of the Customer is : " + SPhone[getSavingsIndex()]);
        System.out.println("\n----------------------------                       BANK ACCOUNT DETAILS                      ---------------------------------- ");
        System.out.println("\nThe Account NO of the Customer is : " + AccountNo[getSavingsIndex()]);
        System.out.println("The Date of Account Creation is : " + Date[getSavingsIndex()]);
        System.out.println("The Bank Balance of the Customer is : " + Balance[getSavingsIndex()]);
        System.out.println("\n=======================================================================================================================");

    }
    public void displayAccountsDeductions(int temp)
    {
        if(AccountNo[0] == null)
        {
            System.out.println("\nSORRY... There is no Any Savings Account Created yet in our Bank ");
        }
        else
        {
            System.out.println("\n===========================================================================================================================");
            for(int i = 0 ; i < temp ; i++)
            {
                System.out.println("\n------------------------------                       ACCOUNT NO : " + (i  +1 )  + "                        ---------------------------------- ");
                System.out.println("\nThe Name of the Customer is : " + SName[i]);
                System.out.println("The Account NO of the Customer is : " + AccountNo[i]);
                System.out.println("The Date of Account Creation is : " + Date[i]);
                System.out.println("The Bank Balance of the Customer is : " + Balance[i]);
                System.out.println("Total Zakat Deductions Made on the Said Account =  " + ZDeduction[i] );
                System.out.println("\n=======================================================================================================================");

            }
        }
    }
    public void checkBalance()
    {
        System.out.println("\n======================================================================================================= ");
        System.out.println("----------------------            The Account Holder Name is : " + SName[getSavingsIndex()] + "                    ------------------- ");
        System.out.println("---------------------             Your Current Account Balance is : " + Balance[getSavingsIndex()] + "                ----------------- ");
        System.out.println("-------------------                              THANK YOU                                --------------------- ");
        System.out.println("========================================================================================================== ");
    }
    public void printStatement(double swithdraw , double sdeposit)
    {
        System.out.println("\n===========================================================================================================================");
        System.out.println("------------------------------                       PRINT STATEMENT                      ---------------------------------- ");
        System.out.println("\nThe Name of the Customer is : " + SName[getSavingsIndex()]);
        System.out.println("The Postal Address of the Customer is : " + SAddress[getSavingsIndex()]);
        System.out.println("The Phone Number of the Customer is : " + SPhone[getSavingsIndex()]);
        System.out.println("The Account NO of the Customer is : " + AccountNo[getSavingsIndex()]);
        System.out.println("\n----------------------------                    TRANSACTION DETAILS                      ---------------------------------- ");
        System.out.println("\nThe Amount Recently Deposited in the Account is : " + sdeposit);
        System.out.println("The Amount Recently WithDrawn from the Account is : " + swithdraw);

        //      GETTING SYSTEM DATE IN JAVA

        SimpleDateFormat formatter = new SimpleDateFormat("dd//MM/yyyy");
        Date date = new Date();
        System.out.println("The Date of the Transaction is :  " + formatter.format(date));

        //      GETTING SYSTEM TIME IN JAVA

        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
        Date date1 = new Date();
        System.out.println("The Time of the Transaction is :  " + formatter1.format(date1));

        System.out.println("The Remaining Balance of the Account is : " + Balance[getSavingsIndex()]);
        System.out.println("\n=======================================================================================================================");

    }
    public void transferAmount(double am)
    {
        if(am > Balance[getSavingsIndex()])
        {
            System.out.println("\nERRORR... The Amount cannot be Transferred because the Amount is Greater than your Bank Balance");
        }
        else
        {
            Balance[getTransferIndex()] = Balance[getTransferIndex()] + am;
            Balance[getSavingsIndex()] = Balance[getSavingsIndex()] - am;
            System.out.println("\n======================================================================================================================= ");
            System.out.println("-----------------           Your Amount has Been Successfully Transferred to Desired Account          ------------------- ");
            System.out.println("------------------                         Receiver Account NO is : " + AccountNo[getTransferIndex()] + "                             -------------------------");
            System.out.println("-----------------                       Name of the Receiver is : " + SName[getTransferIndex()] + "                        -------------------------");
            System.out.println("\n========================================================================================================================");
        }
    }
    public void displayDeductions()
    {
        System.out.println("\n============================================================================================================================== ");
        System.out.println("\n------------------           Total Zakat Deductions Made on the Said Account =  " + ZDeduction[getSavingsIndex()] + "             -----------------");
        System.out.println("\n===================================================================================================================================");
    }
    public  double calculateInterest()
    {
        if(Balance[getSavingsIndex()] == 0.0)
        {
            return 0.0;
        }
        else
        {
            double div = interestrate / 100;
            double res1 = Balance[getSavingsIndex()] * div * 1;
            return res1;
        }
    }
    public void calculateZakat()
    {
        if(Balance[getSavingsIndex()] >= 20000)
        {
            double temp = Balance[getSavingsIndex()] * 2.5;
            double div = temp/100;
            Balance[getSavingsIndex()] = Balance[getSavingsIndex()] - div;
            ZDeduction[getSavingsIndex()] = div;
            System.out.println("\nZakaat has been Successfully Calculated on Your Savings Account ");
            System.out.println("Your Remaining Account Balance is = " + Balance[getSavingsIndex()]);
        }
        else
        {
            System.out.println("\nZakaat Could not be Calculated as your Account Balance is Below 20,000 PKR ");
        }
    }
    public int getSavingsIndex()
    {
        return index;
    }
    public int getTransferIndex()
    {
        return transferindex;
    }

    public double [] getBalance()
    {
        return Balance;
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
        System.out.println("\n1. Deposit Cash \n2. WithDraw Cash \n3. Check Balance \n4. Print Statement \n5. Transfer Amount  ");
        System.out.println("6. Calculate Zaakat \n7. Calculate Interest \n8. Display Deductions \n9. Exit ");
    }

}
