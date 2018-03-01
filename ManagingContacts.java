import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagingContacts {
	static	int i=1;
	ArrayList<Contact> list = new ArrayList<Contact>();
	String addMore = "n";
	String viewMore = "n";
	String editMore = "n";
	String deleteMore="n";
	String moreModify="n";
	Contact cd = new Contact();
	
	public void addContact() {
	
		do {Scanner sc = new Scanner(System.in);
			System.out.println("Welcome to Adding Contact Details:");
			System.out.println("Enter the name:");
			String name = sc.nextLine();
			
			System.out.println("Enter the mobile Number:");
			long mobileNumber=sc.nextLong();
			
			System.out.println("Enter the mailID:");
			String mailID = sc.next();
			
				Contact contact = new Contact(name, mobileNumber, mailID);
				list.add(contact);
				System.out.println(name + " has been Added to contact list");
			
			
			
			System.out.println("Do you want to add more contacts:");
			addMore = sc.next();
			
		} while (addMore.equals("y"));
		
	}
	public void retrieveContact()
	{Scanner sc = new Scanner(System.in);
	ArrayList<Contact> matchedContact=new ArrayList<Contact>();
		do {
			
				System.out.println("Enter the Name to view phone number:");
				String inputName = sc.nextLine();
					for (Contact c1 : list) {
					if (c1.name.equals(inputName))
					{
						matchedContact.add(c1);
					}
					}
		if(matchedContact.isEmpty())
		{
			System.out.println("NO Such contact was found ");
		}
		else
		{
			for(Contact c10:matchedContact)
			{
				System.out.println(c10.name+" "+c10.mobileNumber+" "+c10.mailID);
			}
		}
				System.out.println("Do you want to view more contacts:");
			viewMore = sc.next();
			} while (viewMore.equals("y"));
	}
public void modifyContact()
{Scanner sc = new Scanner(System.in);
	do {
		System.out.println("Enter the name to be modified");
		String input=sc.next();
		ArrayList<Contact> matchedContact=new ArrayList<Contact>();
		for (Contact c1 : list) {
			if (c1.name.equals(input))
			{ 
			
				matchedContact.add(c1);
			    
			}
			else if(matchedContact.isEmpty())
			{
				System.out.println(input+" is not found");
			}
			
			}
	
		for(Contact c:matchedContact)
		{ 
			System.out.println(matchedContact.indexOf(c)+" "+c.name+" "+c.mobileNumber);
		}
		System.out.println("Enter which "+input+" to modify");
		int  modifyChoice=sc.nextInt();
		
		for(Contact c1:matchedContact)
		{
			if(matchedContact.indexOf(c1)==modifyChoice)
			{
				System.out.println("Enter what you want to modify(name or number):");
				String edittingChoice = sc.next();
				switch (edittingChoice) 
				{
				case "name":
					System.out.println("Enter your new name");
					String newName = sc.next();
				c1.setName(newName);
					
					System.out.println(c1.name+" "+c1.mobileNumber);
					break;
				case "number":
					System.out.println("Enter the new mobile number");
					long newMobNumber=sc.nextLong();
					c1.setMobileNumber(newMobNumber);
					System.out.println(c1.name+" "+c1.mobileNumber);
					break;
				default:
					System.out.println("Choice Entered is Invalid");
					break;
					
			}
		}
		
				}
	
		System.out.println("Do you want to make more modifications");
		moreModify=sc.next();
	
} while (moreModify.equals("y"));
}


public void deleteContact()
{ 
	Scanner sc = new Scanner(System.in);
if(list.isEmpty())
{
	System.out.println("Nothing to be deleted as list is empty");
}
else
{
do
{
	
	System.out.println("Enter a name that you want to delete:");
	String deleteInfo=sc.next();
	ArrayList<Contact> matchedContact=new ArrayList<Contact>();
	for (Contact c1 : list) {
		if (c1.name.equals(deleteInfo))
		{ 
		
			matchedContact.add(c1);
		    System.out.println(matchedContact.indexOf(c1)+" "+c1.name+" "+c1.mobileNumber);
		}
		else if(matchedContact.isEmpty())
		{
			System.out.println(deleteInfo+" is not found");
		}
		
		}
	System.out.println("Enter which "+deleteInfo+" you want to delete");
	int index=sc.nextInt();
	cd.remove(list,matchedContact.get(index));
	for(Contact c:list)
	{
		System.out.println(c.name+" "+c.mobileNumber);
	}
/*	
	Iterator<Contact> i=matchedContact.iterator();
	while(i.hasNext())
	{
		Contact cd1=(Contact)i.next();
		if(matchedContact.indexOf(cd1)==index)
		{
		 pos=list.indexOf(cd1);
		}
	}
	
	
	list.remove(pos);
	for(Contact cd3:list)
	{
		System.out.println(cd3.name+" "+cd3.mobileNumber+" "+cd3.mailID);
	}
	*/
	System.out.println("Do you want to delete more:");
	deleteMore=sc.next();
}while(deleteMore.equals("y"));
}
}
public void workOnContact(String c)
{
	if(c.equals("add"))
	{
		addContact();
	}
	else if(c.equals("view"))
	{
		retrieveContact();
	}
	else if(c.equals("modify"))
	{
		modifyContact();
	}
	else if(c.equals("delete"))
	{
		deleteContact();	
	}
	else
		System.out.println("Choice entered is invalid");
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String moreChoice="n";
		Scanner sc = new Scanner(System.in);
		ManagingContacts mc = new ManagingContacts();
		System.out.println("Welcome to the contact Details:");
		System.out.println("User can Add,Retrieve,Edit and Delete any contact information");
		
		do
		{
			System.out.println("Enter what you want to do:");
		String choice=sc.next();
		mc.workOnContact(choice);
		System.out.println("Do you want to make more choices");
		moreChoice=sc.next();
		}while(moreChoice.equals("y"));
		System.out.println("Thank you");
		
			}
	

}
