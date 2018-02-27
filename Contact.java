
public class Contact {
public String name;
long mobileNumber;
String mailID;
Contact()
{
	
}
Contact(String name,long mobileNumber,String mailID)
{
	this.name=name;
	this.mobileNumber=mobileNumber;
	this.mailID=mailID;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getMailID() {
	return mailID;
}
public void setMailID(String mailID) {
	this.mailID = mailID;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	if(name.equals(null))
	{
		System.out.println("Invalid name has been entered.");
	}
	this.name=name;
	
}

}
