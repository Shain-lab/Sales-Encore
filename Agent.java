package packA;
import java.util.*;
import java.sql.*;
public class Agent{Connection con=null;
	public Agent() {try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/project";
		String username="root";
		String password="password";
		con=DriverManager.getConnection(url,username,password);}
		catch(Exception e){
			System.out.println("ERROR: "+e);
		}}
public void updateUser() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter Id:");
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Name:");
		String name=sc.nextLine();
		System.out.print("\tEnter Phone:");
		String phone=sc.nextLine();
		System.out.print("\tEnter Hotness:");
		String hotness=sc.nextLine();
		System.out.print("\tEnter Address:");
		String address=sc.nextLine();
		System.out.print("\tEnter Model:");
		String model=sc.nextLine();
		System.out.print("\tEnter Color:");
		String color=sc.nextLine();
		System.out.print("\tEnter Date:");
		String date=sc.nextLine();
		System.out.print("\tSell By:");
		String by=sc.nextLine();
		String query="insert into user values("+id+",'"+name+"','"+address+"','"+hotness+"','"+model+"','"+color+"','"+date+"','"+by+"','"+phone+"')";
		PreparedStatement pst=con.prepareStatement(query);
		Statement st=con.createStatement();
		int res=st.executeUpdate(query);
		if(res>0){
			System.out.println("\tAdded Successfully");
	}
		else{	
			System.out.println("\tFailed");
}
	}
		
public void updateCustomerHotness() throws Exception{

		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter customer ID:" );
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Hotness:" );
		String hotness=sc.nextLine();
		
		String query="update user set hotness='"+hotness+"' where ID='"+id+"'";
		Statement st=con.createStatement();
		int result=st.executeUpdate(query);
		if(result>0){
			System.out.println("\tUpdate Successful");}
		else{
			System.out.println("\tUpdate Fail");}
	}
public void updateCustomerModel() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter customer ID:" );
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Model:" );
		String model=sc.nextLine();

	String query="update user set model='"+model+"' where ID='"+id+"'";
		Statement st=con.createStatement();
		int result=st.executeUpdate(query);
		if(result>0){
			System.out.println("\tUpdate Successful");}
		else{
			System.out.println("\tUpdate Fail");}
		
}
public void updateCustomerColor() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter customer ID:" );
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Color:" );
		String color=sc.nextLine();

	String query="update user set color='"+color+"' where ID='"+id+"'";
		Statement st=con.createStatement();
		int result=st.executeUpdate(query);
		if(result>0){
			System.out.println("\tUpdate Successful");}
		else{
			System.out.println("\tUpdate Fail");}
}
public void updateCustomerPhone() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter customer ID:" );
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Phone:" );
		String phone=sc.nextLine();

	String query="update user set mobile='"+phone+"' where ID='"+id+"'";
		Statement st=con.createStatement();
		int result=st.executeUpdate(query);
		if(result>0){
			System.out.println("\tUpdate Successful");}
		else{
			System.out.println("\tUpdate Fail");}
}

public void updateAgentPassword() throws Exception{
		Scanner sc2 = new Scanner(System.in);
		System.out.print("\t\tEnter Email:");
		String email=sc2.nextLine();
		System.out.print("\t\tEnter Old Password:");
		String pass=sc2.nextLine();
		String query="select * from agent";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		boolean status=false;
		while(rs.next()){
			if(rs.getString(4).equals(email) && rs.getString(7).equals(pass)){
				status=true;
}
}
	if(status==true){
	System.out.print("\t\tNew Password:");
	String pass1=sc2.nextLine();
	String query1="update agent set password='"+pass1+"' where email='"+email+"'";
	int res=st.executeUpdate(query1);
		if(res>0){
			System.out.println("\tPassword Updated");
	}
}
	else{
	System.out.println("\tWrong Email or Password");
}
}

public void updateAgentPhone() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter agent ID:" );
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Phone:" );
		String phone=sc.nextLine();

	String query="update agent set mobile='"+phone+"' where ID='"+id+"'";
		Statement st=con.createStatement();
		int result=st.executeUpdate(query);
		if(result>0){
			System.out.println("\tUpdate Successful");}
		else{
			System.out.println("\tUpdate Fail");}
}
public void updater() throws Exception{
		System.out.println("\tType of Update");
		System.out.println("\t1.Update Hotness");
		System.out.println("\t2.Update Model");
		System.out.println("\t3.Update Color");
		System.out.println("\t4.Update Mobile");
		System.out.println("\t5.Exit");
		Scanner scc=new Scanner(System.in);
		int ch=Integer.parseInt(scc.nextLine());
	switch(ch){
		case 1: updateCustomerHotness();
		break;
		case 2: updateCustomerModel();
		break;
		case 3: updateCustomerColor();
		break;
		case 4: updateCustomerPhone();
		break;
		case 5: return;
}
}
public void showAll() throws Exception{
		String query="select * from user";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("ID         Name            Address         Hotness	   Model           Color           Date	           BY	           Mobile");	
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
}
		
public void agent() throws Exception{
	while(true){
		System.out.println("\t******************AGENT MENU*****************");
		System.out.println("\t\t1.Add Customer Details");
		System.out.println("\t\t2.Update Customer Data");
		System.out.println("\t\t3.Show Records for Customer");			
		System.out.println("\t\t4.Change Password");
		System.out.println("\t\t5.Change Mobile");
		System.out.println("\t\t6.Log out");
		Scanner sc=new Scanner(System.in);
		int ch=Integer.parseInt(sc.nextLine());	
		switch(ch){
	case 1:updateUser();
	break;
	case 2:updater();
	break;
	case 3:showAll();
	break;
	case 4:updateAgentPassword();
	break;
	case 5:updateAgentPhone();
	break;
	case 6:return;
}
	if(ch==6)
	break;
}		
}
}

