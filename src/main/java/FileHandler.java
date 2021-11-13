import java.io.*;

public class FileHandler extends PersistenceHandler {
	
	public FileHandler()
	{
		
	}
	
	@Override
	public void Save(SavingsAccount saccount,CheckingAccount caccount)
	{
		try
		{
			FileWriter fw = new FileWriter("Accounts.txt",true);
			fw.write(saccount.getAccountNo() + " " + saccount.getBalance() + " " + saccount.getSavingsName() + " " + saccount.getSavingsAddress() + " " + saccount.getSavingsPhoneno() + " "  );
			fw.append("\n");
			fw.write(caccount.getAccountNo() + " " + caccount.getBalance() + " " + caccount.getCheckingName() + " " + caccount.getCheckingAddress() + " " +  caccount.getCheckingPhoneno() + " " );
			fw.close();
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
