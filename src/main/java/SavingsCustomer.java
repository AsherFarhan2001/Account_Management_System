

public class SavingsCustomer {
	
	protected String [] SName = new String [5];
    protected String [] SAddress = new String [5];
    protected String [] SPhone = new String [5];
    public void setSavingsName(String [] Sname , int temp1)
    {
        this.SName[temp1] = Sname[temp1]; 
    }
    public void setSavingsClosingName(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            SName[i] = SName[i + 1];
        }
    }
    public void setSavingsAddress(String [] Saddress , int temp1)
    {
        this.SAddress[temp1] = Saddress[temp1];
    }
    public void setSavingsClosingAddress(int flag , int index)
    {
        for(int i = index ; i < flag ; i++)
        {
            SAddress[i] = SAddress[i + 1];
        }
    }
    public void setSavingsPhoneNo(String [] Sphoneno , int temp1)
    {
        this.SPhone[temp1] = Sphoneno[temp1];
    }
    public void setSavingsClosingPhoneNo(int flag , int index)
    {
        for (int i = index; i < flag; i++) 
        {
            SPhone[i] = SPhone[i + 1];
        }
    }
    public String [] getSavingsName()
    {
        return SName;
    }
    public String [] getSavingsAddress()
    {
        return SAddress;
    }
    public String [] getSavingsPhoneno()
    {
        return SPhone;
    }

}
