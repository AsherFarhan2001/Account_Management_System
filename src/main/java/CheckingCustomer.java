
public class CheckingCustomer {
	
		protected String [] CName = new String [10];
	    protected String [] CAddress = new String [10];
	    protected String [] CPhone = new String [10];
	    public void setCheckingName(String [] Cname , int temp1)
	    {
	        this.CName[temp1] = Cname[temp1];
	    }
	    public void setCheckingClosingName(int flag , int index)
	    {
	        for(int i = index ; i < flag ; i++)
	        {
	            CName[i] = CName[i + 1];
	        }
	    }
	    public void setCheckingAddress(String [] Caddress , int temp1)
	    {
	        this.CAddress[temp1] = Caddress[temp1];
	    }
	    public void setCheckingClosingAddress(int flag , int index)
	    {
	        for(int i = index ; i < flag ; i++)
	        { 
	            CAddress[i] = CAddress[i + 1];
	        }
	    }
	    public void setCheckingPhoneNo(String [] Cphoneno , int temp1)
	    {
	        this.CPhone[temp1] = Cphoneno[temp1];
	    }
	    public void setCheckingClosingPhoneNo(int flag , int index)
	    {
	        for(int i = index ; i < flag ; i++)
	        {
	            CPhone[i] = CPhone[i + 1];
	        }
	    }
	    public String [] getCheckingName()
	    {
	        return CName;
	    }
	    public String [] getCheckingAddress()
	    {
	        return CAddress;
	    }
	    public String [] getCheckingPhoneno()
	    {
	        return CPhone;
	    }


}
