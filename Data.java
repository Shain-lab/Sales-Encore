package packA;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Data{
	Connection con=null;
	public Data() {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/project";
		String username="root";
		String password="password";
		con=DriverManager.getConnection(url,username,password);
}
		catch(Exception e){
		System.out.println("error"+e);
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
	public void showBy() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("\t\tEnter Agent Name:");
		String by=sc.nextLine();
		String query="select * from user where b='"+by+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("ID         Name            Address         Hotness	   Model           Color           Date	           BY	           Mobile");	
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
}
	public void showHotness() throws Exception{
	Scanner sc = new Scanner(System.in);
	System.out.println("\tPlease Select the Nature:");
	System.out.println("\t\t1.Warm");
	System.out.println("\t\t2.Hot");
	System.out.println("\t\t3.Cold");
	int ch=Integer.parseInt(sc.nextLine());
		switch(ch){
			case 1:{
		String query="select * from user where hotness='warm'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
			break;
}
			case 2:{
		String query="select * from user where hotness='hot'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
			break;
}
			case 3:{
		String query="select * from user where hotness='cold'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
			break;
}
			default:{System.out.println("!!!!!!!!!!!!!!!!Wrong Selection!!!!!!!!!!!!!!!!!");}
}
}
	public void showModel() throws Exception{
	Scanner sc = new Scanner(System.in);
	System.out.println("\tPlease Select the Model:");
	System.out.println("\t\t1.Benz");
	System.out.println("\t\t2.SUV-M");
	System.out.println("\t\t3.i-50");
	int ch=Integer.parseInt(sc.nextLine());
		switch(ch){
			case 1:{
		String query="select * from user where model='benz'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
			break;
}
			case 2:{
		String query="select * from user where model='suv-m'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
			break;
}
			case 3:{
		String query="select * from user where model='i-50'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
			break;
}
			default:{System.out.println("\t!!!!!!!!!!!!!!!!Wrong Selection!!!!!!!!!!!!!!!!!");}
}	
}
	public void showDate() throws Exception{
	Scanner sc = new Scanner(System.in);
	System.out.print("\tEnter the Date:");
	String date=sc.nextLine();
	String query="select * from user where date='"+date+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		boolean status=false;
		while(rs.next()){
			if(rs.getString(7).equals(date)){status=true;
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
}
			if(status==false){
				System.out.println("\tNo Matches Found");
}
}
	public void showSalePerson() throws Exception{
	Scanner sc = new Scanner(System.in);
	System.out.print("\tEnter the Name of the Staff: ");
	System.out.println("\tRahul Sarma , Rumi Das , Saket Shah, Ankit Verma ");
	String n=sc.nextLine();
	String query="select * from user where b='"+n+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		boolean status=false;
		while(rs.next()){
			status=true;
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
}
		if(status==false){
			System.out.println("\t!!!!!!!!!!!!Entered Wrong Name!!!!!!!!!!!!!!");}			
}
	public void addSalePerson() throws Exception {

		
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter Id:");
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\tEnter Name:");
		String name=sc.nextLine();
		System.out.print("\tEnter Phone:");
		String phone=sc.nextLine();
		System.out.print("\tEnter Email:");
		String email=sc.nextLine();
		System.out.print("\tEnter Address:");
		String address=sc.nextLine();
		System.out.print("\tEnter Status:");
		String status=sc.nextLine();
		System.out.print("\tEnter Password:");
		String pass=sc.nextLine();
		String query="insert into agent values("+id+",'"+name+"','"+phone+"','"+email+"','"+address+"','"+status+"','"+pass+"')";
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
	public void status() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter Id :");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("\tPlease Select - 1.Activate   2.Deactivate   3.exit");
		int ch=Integer.parseInt(sc.nextLine());
		switch(ch){
	case 1:{ 
		String query="update agent set active='Y' where id="+id+"";
		Statement st=con.createStatement();
		int res=st.executeUpdate(query);
		if(res>0){
			System.out.println("\tAgent Activated");
	}
		else{	
			System.out.println("\tFailed");
}
	break;
}
	case 2:{ 
		String query="update agent set active='N' where id="+id+"";
		Statement st=con.createStatement();
		int res=st.executeUpdate(query);
		if(res>0){
			System.out.println("\tAgent Deactivated");
	}
		else{	
			System.out.println("\tFailed");
}
	break;
}
	case 3:{return;}
}
}
	public void deleteUser() throws Exception {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("\tEnter Id :");
		int id=Integer.parseInt(sc.nextLine());
		String query="delete from user where id="+id;
		Statement st=con.createStatement();
		int res=st.executeUpdate(query);
		if(res>0){
			System.out.println("\tDeleted");
	}
		else{	
			System.out.println("\tFailed");
}
}
	public void change() throws Exception{
		Scanner sc2 = new Scanner(System.in);
		System.out.print("\t\tEnter Email:");
		String email=sc2.nextLine();
		System.out.print("\t\tEnter Old Password:");
		String pass=sc2.nextLine();
		String query="select * from admin";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		boolean status=false;
		while(rs.next()){
			if(rs.getString(3).equals(email) && rs.getString(4).equals(pass)){
				status=true;
}
}
	if(status==true){
	System.out.print("\t\tEnter New Password:");
	String pass1=sc2.nextLine();
	String query1="update admin set password='"+pass1+"' where email='"+email+"'";
	int res=st.executeUpdate(query1);
		if(res>0){
			System.out.println("\t\tPassword Updated");
	}
}
	else{
	System.out.println("\t\tWrong Email or Password");
}
}
	public void filter() throws Exception{
		System.out.println("\tType of Filter");
		System.out.println("\t1.By Hotness");
		System.out.println("\t2.By Model");
		System.out.println("\t3.By Date");
		System.out.println("\t4.By Employee");
		System.out.println("\t5.Exit");
		Scanner scc=new Scanner(System.in);
		int ch=Integer.parseInt(scc.nextLine());
	switch(ch){
		case 1: showHotness();
		break;
		case 2: showModel();
		break;
		case 3: showDate();
		break;
		case 4: showSalePerson();
		break;
		case 5: return;
}
}

	public void admin() throws Exception{
	while(true){
		System.out.println("\t******************ADMINISTRATOR MENU*****************");
		System.out.println("\t\t1.Show Records of Customers");
		System.out.println("\t\t2.Show By Filter");
		System.out.println("\t\t3.Add Employee");
		System.out.println("\t\t4.Deactivate/Activate Account");
		System.out.println("\t\t5.Delete Customer Details");
		System.out.println("\t\t6.Change Password");
		System.out.println("\t\t7.Selled By");
		System.out.println("\t\t8.Log out");
		Scanner cc=new Scanner(System.in);
		int ch=Integer.parseInt(cc.nextLine());
		switch(ch){
	case 1:showAll();
	break;
	case 2:filter();
	break;
	case 3:addSalePerson();
	break;
	case 4:status();
	break;
	case 5:deleteUser();
	break;
	case 6:change();
	break;
	case 7:showBy();
	break;
	case 8:return;
}
	if(ch==8)
	break;
}		
}
}

