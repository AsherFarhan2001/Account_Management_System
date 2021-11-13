import java.io.*;
import java.util.Scanner;


public class AccountManagementSystem {

	public static void main(String[] args) {
		
		int Ssize = 10;                  // size for savings account array
        int Csize = 10;                              // Size for checking account array
        int Snamesize = 10;
        int Cnamesize = 10;
        int Saddsize = 10;
        int Caddsize = 10;
        int Sphonesize = 10;
        int Cphonesize = 10;
        int Sdatesize = 10;
        int Cdatesize = 10;
        int Cbalsize = 10;
        int Sbalsize = 10;
        int Sverify = 0 , Sverifytemp = 0;
        int Cverify = 0 , Cverifytemp = 0;
        int Ctransferindex = 0 , Stransferindex = 0;
        String [] Saccount = new String [Ssize];
        String [] Sname = new String [Snamesize];
        String [] Saddress = new String [Saddsize];
        String [] Sphone = new String [Sphonesize];
        String [] Sdate = new String [Sdatesize];
        double [] Sbalance = new double [Sbalsize];
        double [] Cbalance = new double [Cbalsize];
        String [] Caccount = new String [Csize];
        String [] Cname = new String [Cnamesize];
        String [] Caddress = new String [Caddsize];
        String [] Cphone = new String [Cphonesize];
        String [] Cdate = new String [Cdatesize];
        
        double [] bal,bal1;
        String [] acc,acc1;
        
        // connecting to Data Base
        
        int opt;
        Scanner input1 = new Scanner (System.in);
        System.out.println("Selecting the Data Base ");
        System.out.println("Press 1 for File ");
        System.out.println("Press 2 for Oracle Data Base ");
        opt = input1.nextInt();
        CheckingAccount CA = new CheckingAccount(opt);
        SavingsAccount SA = new SavingsAccount(opt);
        
        //----------------------------------
        
        for(int i = 0 ; i < 10 ; i++)
        {
            Sbalance[i] = 0.0;
        }
        for(int i = 0 ; i < 10 ; i++)
        {
            Cbalance[i] = 0.0;
        }

        int Sflag = 0 , Sflagtemp = 0;                                  // indicating the index of account holder for savings account
        int Cflag = 0 , Cflagtemp = 0;                                  // indicating the index of account holder for checking account
        Scanner input = new Scanner (System.in);
        int opt1 = 0 , opt2 = 0 , opt3 = 0 , opt4 = 0 , opt5 = 0 ,opt6 = 0;
        int Sindex = 0 , Cindex = 0;
        double Cwithdrawamo = 0.0 , Cdepositamo = 0.0;
        double Swithdrawamo = 0.0 , Sdepositamo = 0.0;
        do
        {
            System.out.println("\n====================================================================================================");
            System.out.println("---------------------                WELCOME TO BANK AL HABIB             -------------------------- ");
            System.out.println("=======================================================================================================");
            System.out.println("\n1. Open a New Account \n2. Close the Account \n3. Login From Existing Account ");
            System.out.println("4. Specify the Interest Rate Applicable to all Saving Accounts \n5. Display all Account Details, including the Bank Owner Details ");
            System.out.println("6. Display all Accounts Deductions along with Account Details \n7. Exit ");
            opt1 = input.nextInt();
            if(opt1 == 1)
            {
                System.out.println("\nSelect the Account you Want to Create ");
                System.out.println("\n1. Checking Account \n2. Savings Account \n3. Back to Main Menu");
                opt2 = input.nextInt();
                if(opt2 == 1)               // checking account create
                {
                    boolean check1 = true;
                    System.out.println("\n============================================================================================== ");
                    System.out.println("----------------               WELCOME TO CHECKING ACCOUNT               --------------------- ");
                    System.out.println("==================================================================================================");
                    input.nextLine();
                    System.out.println("\nEnter Your Name : ");
                    Cname [Cflag] = input.nextLine();
                    System.out.println("\nEnter your Postal Address " );
                    Caddress [Cflag] = input.nextLine();
                    System.out.println("\nEnter your Phone Number : ");
                    Cphone [Cflag] = input.nextLine();
                    System.out.println("\nEnter your Account NO : ");
                    Caccount [Cflag] = input.nextLine();
                    System.out.println("\nEnter the Today's Date in Format  (DD/MM/YY) ");
                    Cdate [Cflag] = input.nextLine();
                    int temp = Cflag;
                    Cflag++;
                    for(int i = 0 ; i < Cflag - 1 ; i++)                // loop for checking for duplicate  Checking account creation
                    {
                        if(Caccount[temp].equals(Caccount[i]))
                        {
                            System.out.println("\n---------------- Account With this Account NO Already Exists.. Please Retry -------------------");

                            Cflag--;                // Cflag decrements when account already exists
                            check1 = false;
                        }
                        else if(Cname[temp].equals(Cname[i]))
                        {
                            System.out.println("\n------------------ Account with this Name Already Exists.. Please Retry ---------------------- ");
                            Cflag--;
                            check1 = false;
                        }
                    }
                    Cflagtemp = Cflag;
                    if(check1 == true)                  // If there is a unique new Account then this loop proceeds
                    {
                        int sub = Cflag - 1;
                        CA.setAccountNo(Caccount,sub);
                        CA.setCheckingName(Cname,sub);
                        CA.setCheckingAddress(Caddress,sub);
                        CA.setCheckingPhoneNo(Cphone,sub);
                        CA.setDate(Cdate,sub);
                        CA.setBalance(Cbalance,sub);
                        System.out.println("\nYour Checking Account has Been Successfully Opened in Bank AL Habib ");
                    }
                }
                else if(opt2 == 2)              // savings account create
                {
                    boolean check = true;
                    System.out.println("\n============================================================================================== ");
                    System.out.println("----------------                WELCOME TO SAVINGS ACCOUNT                --------------------- ");
                    System.out.println("==================================================================================================");
                    input.nextLine();
                    System.out.println("\nEnter Your Name : ");
                    Sname [Sflag] = input.nextLine();
                    System.out.println("\nEnter your Postal Address " );
                    Saddress [Sflag] = input.nextLine();
                    System.out.println("\nEnter your Phone Number : ");
                    Sphone [Sflag] = input.nextLine();
                    System.out.println("\nEnter your Account NO : ");
                    Saccount [Sflag] = input.nextLine();
                    System.out.println("\nEnter the Today's Date in Format  (DD/MM/YY) ");
                    Sdate [Sflag] = input.nextLine();
                    int temp1 = Sflag;
                    Sflag++;
                    for(int i = 0 ; i < Sflag - 1 ; i++)                    // loop for checking for duplicate Savings account creation
                    {
                        if(Saccount[temp1].equals(Saccount[i]))
                        {
                            System.out.println("\nAccount With this Account NO Already Exists.. Please Retry ");
                            Sflag--;
                            check = false;
                        }
                        else if(Sname[temp1].equals(Sname[i]))
                        {
                            System.out.println("\n------------------ Account with this Name Already Exists.. Please Retry ---------------------- ");
                            Sflag--;
                            check = false;
                        }
                    }
                    Sflagtemp = Sflag;
                    if(check == true)
                    {
                        int sub = Sflag - 1;
                        SA.setAccountNo(Saccount,sub);
                        SA.setSavingsName(Sname,sub);
                        SA.setSavingsAddress(Saddress,sub);
                        SA.setSavingsPhoneNo(Sphone,sub);
                        SA.setDate(Sdate,sub);
                        SA.setBalance(Sbalance,sub);
                        System.out.println("\nYour Savings Account has Been Successfully Opened in Bank AL Habib ");
                    }
                }
            }

            else if(opt1 == 2)
            {
                int var = 0;
                do
                {
                    var = 0;
                    System.out.println("\nSelect the Account you Want to Close ");
                    System.out.println("\n1. Checking Account \n2. Savings Account \n3. Back to Main Menu ");
                    opt6 = input.nextInt();
                    if(opt6 == 1)                   // Checking Account Login
                    {
                        if (Cflag == 0)
                        {
                            System.out.println("\nThere is no any Account Created Yet.. Please Open an Account First ");
                            var = 0;
                            Cverifytemp = 0;
                        }
                        else
                        {
                            System.out.println("\n============================================================================================== ");
                            System.out.println("----------------               WELCOME TO CHECKING ACCOUNT               --------------------- ");
                            System.out.println("==================================================================================================");
                            input.nextLine();
                            System.out.println("Please Enter your Account NO : ");
                            String no = input.nextLine();
                            Cindex = 0;
                            Cverifytemp = CA.verifyAccountNo(no, Cflag, Cindex);
                            if (Cverifytemp == 1)
                            {
                                System.out.println("\nYour Account Has Been Successfully Closed From Our Bank ");
                                System.out.println("\nThank you for Using our Banking Services :) ");
                                int temp = CA.getCheckingIndex();
                                CA.setCheckingClosingName(Cflag,temp);                //name array , counter , index
                                CA.setCheckingClosingAddress(Cflag,temp);
                                CA.setCheckingClosingPhoneNo(Cflag,temp);
                                CA.setCheckingClosingDate(Cflag,temp);
                                CA.setCheckingClosingAccount(Cflag,temp);
                                CA.setCheckingClosingBalance(Cflag,temp);
                                CA.setCheckingDepositDeduction(Cflag,temp);
                                CA.setCheckingWithDrawDeductions(Cflag,temp);
                                Cflag--;
                                Cflagtemp = Cflag;
                                Cname = CA.getCheckingName();
                                Caddress = CA.getCheckingAddress();
                                Cphone = CA.getCheckingPhoneno();
                                Cdate = CA.getDate();
                                Cbalance = CA.getBalance();
                                Caccount = CA.getAccountNo();
                            }
                            else
                            {
                                CA.accountNotVerifyMessage();
                            }
                            var = 1;
                        }
                    }
                    else if(opt6 == 2)
                    {
                        if(Sflag == 0)
                        {
                            System.out.println("\nThere is no any Account Created Yet.. Please Open an Account and then Login ");
                            var = 0;
                            Sverifytemp = 0;
                        }
                        else
                        {
                            System.out.println("\n============================================================================================== ");
                            System.out.println("----------------                WELCOME TO SAVINGS ACCOUNT                --------------------- ");
                            System.out.println("==================================================================================================");
                            input.nextLine();
                            System.out.println("Please Enter your Account NO : ");
                            String no = input.nextLine();
                            Sindex = 0;
                            Sverifytemp = SA.verifyAccountNo(no, Sflag, Sindex);
                            if (Sverifytemp == 1)
                            {
                                System.out.println("\nYour Account Has Been Successfully Closed From Our Bank ");
                                System.out.println("\nThank you for Using our Banking Services :) ");
                                int temp = SA.getSavingsIndex();
                                SA.setSavingsClosingName(Sflag,temp);                //name array , counter , index
                                SA.setSavingsClosingAddress(Sflag,temp);
                                SA.setSavingsClosingPhoneNo(Sflag,temp);
                                SA.setSavingsClosingDate(Sflag,temp);
                                SA.setSavingsClosingAccount(Sflag,temp);
                                SA.setSavingsClosingBalance(Sflag,temp);
                                SA.setSavingsZakatDeduction(Sflag,temp);
                                Sflag--;
                                Sflagtemp = Sflag;
                                Sname = SA.getSavingsName();
                                Saddress = SA.getSavingsAddress();
                                Sphone = SA.getSavingsPhoneno();
                                Sdate = SA.getDate();
                                Sbalance = SA.getBalance();
                                Saccount = SA.getAccountNo();

                            }
                            else
                            {
                                SA.accountNotVerifyMessage();
                            }
                            var = 2;
                        }
                    }
                } while((var == 1 && Cverifytemp == 0) || (var == 2 && Sverifytemp == 0 ));
            }

            else if(opt1 == 3)
            {
                int var = 0;
                do                  // do while loop for processing account login menu
                {
                    var = 0;
                    System.out.println("\nSelect the Account you Want to Login From ");
                    System.out.println("\n1. Checking Account \n2. Savings Account \n3. Back to Main Menu");
                    opt3 = input.nextInt();
                    if(opt3 == 1)                   // Checking Account Login
                    {
                        if(Cflag == 0)
                        {
                            System.out.println("\nThere is no any Account Created Yet.. Please Open an Account and then Login ");
                            var = 0;
                            Cverify = 0;
                        }
                        else
                        {
                            System.out.println("\n============================================================================================== ");
                            System.out.println("----------------               WELCOME TO CHECKING ACCOUNT               --------------------- ");
                            System.out.println("==================================================================================================");
                            input.nextLine();
                            System.out.println("Please Enter your Account NO : ");
                            String no = input.nextLine();
                            Cindex = 0; 
                            Cverify = CA.verifyAccountNo(no,Cflag,Cindex);
                            int temp = CA.getCheckingIndex();
                            if(Cverify == 1)
                            {
                                CA.accountVerifyMessage();
                                CA.bankMenu();
                                opt4 = input.nextInt();
                                while(opt4 == 1 || opt4 == 2 || opt4 == 3 || opt4 == 4 || opt4 == 5 || opt4 == 6)
                                {
                                    if(opt4 == 1)                       // for deposit cash
                                    {
                                        System.out.println("\nINSTRUCTIONS : ");
                                        System.out.println("\nThe Customer will get 2 FREE Transactions Per Month, After that Transaction Fee of 10 PKR will be charged for each Transaction ");
                                        System.out.println("\nIn a Month Which time are you Depositing the Amount in the Bank : ");
                                        int mont = input.nextInt();
                                        System.out.println("\nEnter the Amount You want to Deposit in Bank : ");
                                        double amo = input.nextDouble();
                                        Cdepositamo = amo;                          // for keeping record of recently deposit amount
                                        CA.depositCash(amo,mont);
                                        System.out.println("\n======================================================================================================== ");
                                        System.out.println("------------------       The Amount Has been Successfully Deposited in the Account     ----------------- ");
                                        System.out.println("------------------                        THANK YOU                                   ------------------- ");
                                        System.out.println("=========================================================================================================");
                                    }
                                    else if(opt4 == 2)              // for withdraw cash
                                    {
                                        System.out.println("\nINSTRUCTIONS : ");
                                        System.out.println("\nThe Customer will get 2 FREE Transactions Per Month, After that Transaction Fee of 10 PKR will be charged for each Transaction ");
                                        System.out.println("The Checking Account Customers can WithDraw more than their Account Balance at most 5000 PKR ");
                                        System.out.println("\nIn a Month Which time are you WithDrawing the Amount From the Bank : ");
                                        int mont = input.nextInt();
                                        System.out.println("\nEnter the Amount you Want to WithDraw from Bank : ");
                                        double amo = input.nextDouble();
                                        Cwithdrawamo = amo;                     // for keeping record of recently withdrawn amount
                                        CA.withDrawCash(amo,mont);
                                    }
                                    else if(opt4 == 3)              // to check balance
                                    {
                                        CA.checkBalance();
                                    }
                                    else if(opt4 == 4)                  // print statement
                                    {
                                        CA.printStatement(Cwithdrawamo,Cdepositamo);
                                    }
                                    else if(opt4 == 5)              // transfer amount to another account
                                    {
                                        input.nextLine();
                                        System.out.println("\nEnter the Account NO you want to Transfer Amount to : ");
                                        String account = input.nextLine();
                                        Ctransferindex = 0;
                                        int temp1 = CA.verifyTransferAccountNo(account,Cflag,Ctransferindex);
                                        if(temp1 == 1)
                                        {
                                            System.out.println("\nEnter the Amount you Want to Transfer to the Specified Account : ");
                                            double am = input.nextDouble();
                                            CA.transferAmount(am);

                                        }
                                        else
                                        {
                                            System.out.println("\nThe Account No you Provided is Invalid or Doesn't Exist ");
                                            System.out.println("\nPlease Retry... ");
                                        }
                                    }
                                    else if(opt4 == 6)
                                    {
                                        CA.displayDeductions();
                                    }
                                    CA.bankMenu();
                                    opt4 = input.nextInt();
                                }
                            }
                            else
                            {
                                CA.accountNotVerifyMessage();
                            }
                            var = 1;
                        }
                    }
                    else if(opt3 == 2)              // Savings AcCount Login
                    {
                        if(Sflag == 0)
                        {
                            System.out.println("\nThere is no any Account Created Yet.. Please Open an Account and then Login ");
                            var = 0;
                            Sverify = 0;
                        }
                        else
                        {
                            System.out.println("\n============================================================================================== ");
                            System.out.println("----------------                WELCOME TO SAVINGS ACCOUNT                --------------------- ");
                            System.out.println("==================================================================================================");
                            input.nextLine();
                            System.out.println("Please Enter your Account NO : ");
                            String no = input.nextLine();
                            Sindex = 0;
                            Sverify = SA.verifyAccountNo(no,Sflag,Sindex);
                            if(Sverify == 1)
                            {
                                SA.accountVerifyMessage();
                                SA.bankMenu();
                                opt5 = input.nextInt();
                                while(opt5 == 1 || opt5 == 2 || opt5 == 3 || opt5 == 4 || opt5 == 5 || opt5 == 6 || opt5 == 7 || opt5 == 8)
                                {
                                    if(opt5 == 1)                   // for deposit cash
                                    {
                                        System.out.println("\nEnter the Amount You want to Deposit in Bank : ");
                                        double amo = input.nextDouble();
                                        Sdepositamo = amo;                  // for keeping record of recently deposit amount
                                        SA.depositCash(amo);
                                        System.out.println("\n======================================================================================================== ");
                                        System.out.println("------------------       The Amount Has been Successfully Deposited in the Account     ----------------- ");
                                        System.out.println("------------------                        THANK YOU                                   ------------------- ");
                                        System.out.println("=========================================================================================================");
                                    }
                                    else if(opt5 == 2)                  // for withdraw cash
                                    {
                                        System.out.println("\nINSTRUCTIONS : ");
                                        System.out.println("\nThe Savings Account Customers cannot WithDraw more than their Account Balance  ");
                                        System.out.println("\nEnter the Amount you Want to WithDraw from Bank : ");
                                        double amo = input.nextDouble();
                                        Swithdrawamo = amo;                      // for keeping record of recently withdrawn amount
                                        SA.withDrawCash(amo);
                                    }
                                    else if(opt5 == 3)              // for inquiring account balance
                                    {
                                        SA.checkBalance();
                                    }
                                    else if(opt5 == 4)
                                    {
                                        SA.printStatement(Swithdrawamo,Sdepositamo);
                                    }
                                    else if(opt5 == 5)
                                    {
                                        input.nextLine();
                                        System.out.println("\nEnter the Account NO you want to Transfer Amount to : ");
                                        String account = input.nextLine();
                                        Stransferindex = 0;
                                        int temp1 = SA.verifyTransferAccountNo(account,Sflag,Stransferindex);
                                        if(temp1 == 1)
                                        {
                                            System.out.println("\nEnter the Amount you Want to Transfer to the Specified Account : ");
                                            double am = input.nextDouble();
                                            SA.transferAmount(am);

                                        }
                                        else
                                        {
                                            System.out.println("\nThe Account No you Provided is Invalid or Doesn't Exist ");
                                            System.out.println("\nPlease Retry... ");
                                        }
                                    }
                                    else if(opt5 == 6)              // calculating Zakaat
                                    {
                                        SA.calculateZakat();
                                    }
                                    else if(opt5 == 7)              // calculating annual interest in the balance
                                    {
                                        double temp;
                                        temp = SA.calculateInterest();
                                        if(temp == 0.0)
                                        {
                                            System.out.println("\nPlease Deposit Some Amount in the Bank, The Account is Empty... THANK YOU ");
                                        }
                                        else
                                        {
                                            System.out.println("\nThe Interest has Been Successfully Calculated ");
                                            System.out.println("The Interest = " + temp + " % ");
                                        }
                                    }
                                    else if(opt5 == 8)
                                    {
                                        SA.displayDeductions();
                                    }
                                    SA.bankMenu();
                                    opt5 = input.nextInt();
                                }
                            }
                            else
                            {
                                SA.accountNotVerifyMessage();
                            }
                            var = 2;
                        }
                    }

                } while((var == 1 && Cverify == 0) || (var == 2 && Sverify == 0 ));

            }
            else if(opt1 == 4)
            {
                System.out.println("\nINSTRUCTIONS : ");
                System.out.println("\nBy default the Interest Rate is Set to 1 % And it will be Calculated on Annual Basis ");
                System.out.println("\nInterest is Applicable on all Savings Accounts ");
                System.out.println("\nSpecify the Interest Rate that the Account Earns Per Year : ");
                double inte = input.nextDouble();
                SA.setInterestRate(inte);
                System.out.println("\nThe Interest Rate is Set to = " + inte + " % ");
            }
            else if(opt1 == 5)
            {
                int var1 = 0;
                do
                {
                    var1 = 0;
                    System.out.println("\nSelect the Account you Want to Login From ");
                    System.out.println("\n1. Checking Account \n2. Savings Account \n3. Back to Main Menu ");
                    opt6 = input.nextInt();
                    if(opt6 == 1)                   // Checking Account Login
                    {
                        if (Cflagtemp == 0)
                        {
                            System.out.println("\nThere is no any Account Created Yet.. Please Open an Account and then Login ");
                            var1 = 0;
                            Cverifytemp = 0;
                        }
                        else
                        {
                            System.out.println("\n============================================================================================== ");
                            System.out.println("----------------               WELCOME TO CHECKING ACCOUNT               --------------------- ");
                            System.out.println("==================================================================================================");
                            input.nextLine();
                            System.out.println("Please Enter your Account NO : ");
                            String no = input.nextLine();
                            Cindex = 0;
                            Cverifytemp = CA.verifyAccountNo(no, Cflagtemp, Cindex);
                            if (Cverifytemp == 1)
                            {
                                CA.accountVerifyMessage();
                                CA.displayAccountDetails();
                            }
                            else
                            {
                                CA.accountNotVerifyMessage();
                            }
                            var1 = 1;
                        }
                    }
                    else if(opt6 == 2)
                    {
                        if(Sflagtemp == 0)
                        {
                            System.out.println("\nThere is no any Account Created Yet.. Please Open an Account and then Login ");
                            var1 = 0;
                            Sverifytemp = 0;
                        }
                        else
                        {
                            System.out.println("\n============================================================================================== ");
                            System.out.println("----------------                WELCOME TO SAVINGS ACCOUNT                --------------------- ");
                            System.out.println("==================================================================================================");
                            input.nextLine();
                            System.out.println("Please Enter your Account NO : ");
                            String no = input.nextLine();
                            Sindex = 0;
                            Sverifytemp = SA.verifyAccountNo(no, Sflagtemp, Sindex);
                            if (Sverifytemp == 1)
                            {
                                SA.accountVerifyMessage();
                                SA.displayAccountDetails();
                            }
                            else
                            {
                                SA.accountNotVerifyMessage();
                            }
                            var1 = 2;
                        }
                    }
                } while((var1 == 1 && Cverifytemp == 0) || (var1 == 2 && Sverifytemp == 0 ));
            }

            else if(opt1 == 6)
            {
                System.out.println("\nSelect the Account of which You want to see all Deduction Details : ");
                System.out.println("\n1. Checking Account \n2. Savings Account \n3. Back to Main Menu ");
                opt6 = input.nextInt();
                if (opt6 == 1)
                {
                    CA.displayAccountsDeductions(Cflagtemp);
                }
                else if (opt6 == 2)
                {
                    SA.displayAccountsDeductions(Sflagtemp);
                }
            }
            bal = CA.getBalance();
            bal1 = SA.getBalance();
            acc = CA.getAccountNo();
            acc1 = SA.getAccountNo();

        } while (opt1 != 7);

        // ------------------------- FILE WRITING FOR SAVINGS ACCOUNT ------------------------

        try
        {
            FileWriter filewrite = new FileWriter("Savings Account Database.txt");
            for(int i = 0 ; i < Sflag ; i++)
            {
                filewrite.write((i + 1) + ". " + acc1[i] + "   " + bal1[i] + "");
                filewrite.append('\n');
            }
            filewrite.close();

        }   catch(IOException e){
            System.out.println("ddd");
            e.printStackTrace();
        }

        // ---------------------------- FILE WRITING FOR CHECKING ACCOUNT --------------------

        try
        {
            FileWriter filewrite = new FileWriter("Checking Account Database.txt");
            for(int i = 0 ; i < Cflag ; i++)
            {
                filewrite.write((i + 1) + ". " + acc[i] + "   " + bal[i] + "");
                filewrite.append('\n');
            }
            filewrite.close();

        }   catch(IOException e){
            System.out.println("ddd");
            e.printStackTrace();
        }

        System.out.println("\n!!!!!!!!!!!!!!! THE BANK DATABASE IS SUCCESSFULLY UPDATED !!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");

	}

}
