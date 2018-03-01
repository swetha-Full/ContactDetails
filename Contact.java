import java.util.ArrayList;

public class Contact {
public String name;
long mobileNumber;
String mailID;
Contact()
{
	
}ArrayList<Contact> list=new ArrayList<Contact>();
public void remove(ArrayList a,Contact contact)
{
	a.remove(contact);
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

public String toString()
{
	return name+" "+mobileNumber;
}
}
