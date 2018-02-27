import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagingContacts {

	ArrayList<Contact> list = new ArrayList<Contact>();
	String addMore = "n";
	String viewMore = "n";
	String editMore = "n";
	String deleteMore="n";
	String moreModify="n";
	Contact cd = new Contact();
	public void addContact() {
		Pattern namePattern=Pattern.compile("[A-Z]*[a-z]+[ \t\r\n][A-Z]*[a-z]+");
		Pattern mobileNumberPattern=Pattern.compile("[987]{1}[0-9]{9}");
		Pattern mailPattern=Pattern.compile("[A-Z]*[a-z]+[0-9]*[_]*[a-z]*@[a-z]+.[a-z]{2,5}");
		do {Scanner sc = new Scanner(System.in);
			System.out.println("Welcome to Adding Contact Details:");
			System.out.println("Enter the name:");
			String name = sc.nextLine();
			Matcher namematcher=namePattern.matcher(name);
			boolean nameMatches=namematcher.matches();
			System.out.println("Enter the mobile Number:");
			long mobileNumber=sc.nextLong();
			String numstring=String.valueOf(mobileNumber);
			Matcher mobileNumbermatcher=mobileNumberPattern.matcher(numstring);
			boolean numMatches=mobileNumbermatcher.matches();
			System.out.println("Enter the mailID:");
			String mailID = sc.next();
			Matcher mailmatcher=mailPattern.matcher(mailID);
			boolean mailMatches=mailmatcher.matches();
			if(nameMatches && mailMatches && numMatches)
			{
				Contact contact = new Contact(name, mobileNumber, mailID);
				list.add(contact);
				System.out.println(name + " has been Added to contact list");
			}
			else
			{
				System.out.println("Any value you have entered doesnot support the pattern that has been defined.");
			}
			
			
			System.out.println("Do you want to add more contacts:");
			addMore = sc.next();
			
		} while (addMore.equals("y"));
	}
	public void retrieveContact()
	{Scanner sc = new Scanner(System.in);
		do {
			if (list.isEmpty()) {
				System.out.println("No Contact has been Added, Please added then View");
				break;
			}
			
			else {
				System.out.println("Enter the Name to view phone number:");
				String inputName = sc.nextLine();
				for (Contact c1 : list) {
					if (c1.name.equals(inputName))
						System.out.println(c1.name + " " + c1.mobileNumber + " " + c1.mailID);
					else
						System.out.println("Search Unsuccessful");
				}

				System.out.println("Do you want to view more contacts:");
				viewMore = sc.next();
			}

		} while (viewMore.equals("y"));
	}
public void modifyContact()
{Scanner sc = new Scanner(System.in);
	do {
		System.out.println("Enter the name to be modified");
		String input=sc.next();
				Iterator i=list.iterator();
				while(i.hasNext())
				{
					Contact c=(Contact)i.next();
					if(c.name.equals(input))
					{
						System.out.println("Enter what you want to modify:");
						System.out.println("Press 1 if you want to edit name");
						System.out.println("Press 2 if you want to edit mobile number:");
						System.out.println("Press 3 if you want to edit the mailID");
						Scanner sc1 = new Scanner(System.in);
						String edittingChoice = sc1.next();
						switch (edittingChoice) 
						{
						case "name":
							System.out.println("Enter your new name");
							String newName = sc1.next();
							c.setName(newName);
							
							System.out.println(c.name + " " + c.mailID + " " + c.mobileNumber);
							break;
						case "number":
							System.out.println("Enter the new mobile number");
							long newMobNumber=sc1.nextLong();
							c.setMobileNumber(newMobNumber);
							System.out.println(c.name+" "+c.mobileNumber+" "+c.mailID);
							break;
						case "mail":
							System.out.println("Enter the new mailID");
							String newMailId=sc1.next();
							c.setMailID(newMailId);
							System.out.println(c.name+" "+c.mobileNumber+" "+c.mailID);
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
{Scanner sc = new Scanner(System.in);
int pos=0;
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
	Iterator<Contact> i=list.iterator();
	while(i.hasNext())
	{
		Contact cd1=(Contact)i.next();
		if(cd1.name.equals(deleteInfo))
		{
		 pos=list.indexOf(cd1);
		}
	}
	
	
	list.remove(pos);
	for(Contact cd3:list)
	{
		System.out.println(cd3.name+" "+cd3.mobileNumber+" "+cd3.mailID);
	}
	
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
