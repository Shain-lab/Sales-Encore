package Login;
import packA.*;
import java.util.*;
import java.sql.*;
import java.io.*;
class MD {
Connection con=null;
	MD() {
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

void register() throws Exception {

		
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\tPlease Select the Type of Registration");
		System.out.println("\t\t1.Register Agents 	2.Register Admin");
		int ch=Integer.parseInt(sc.nextLine());
		switch(ch){
		
	case 1:{ 
		System.out.print("\t\tEnter Id:");
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("\t\tEnter Name:");
		String name=sc.nextLine();
		System.out.print("\t\tEnter Phone:");
		String phone=sc.nextLine();
		System.out.print("\t\tEnter Email:");
		String email=sc.nextLine();
		System.out.print("\t\tEnter Address:");
		String address=sc.nextLine();
		System.out.print("\t\tEnter Status:");
		String status=sc.nextLine();
		System.out.print("\t\tEnter Password:");
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
	break;
}
	case 2:{ System.out.print("\t\tEnter Id:");
		 int id=Integer.parseInt(sc.nextLine());
		 System.out.print("\t\tEnter Name:");
		 String name=sc.nextLine();
		 System.out.print("\t\tEnter Email:");
		 String email=sc.nextLine();
		 System.out.print("\t\tEnter Password:");
		 String pass=sc.nextLine();	
		 String query="insert into admin values("+id+",'"+name+"','"+email+"','"+pass+"')";
		 PreparedStatement pst=con.prepareStatement(query);
		 Statement st=con.createStatement();
		 int res=st.executeUpdate(query);
		 if(res>0){
			System.out.println("\t\tAdded Successfully");
	}
		 else{	
			System.out.println("\t\tFailed");
}
	break;
}
	default:System.out.println("\t\tWrong Selection");
}
}

void login() throws Exception{
		System.out.println("\t\t***Login***");
		System.out.print("\t->Email:");		
		Scanner sc = new Scanner(System.in);
		Console c=System.console();
		String email=sc.nextLine();
		System.out.print("\t->Password:"); 
		String pass=new String(c.readPassword()); 
		String query="select * from agent";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		boolean status=false;
		String query1="select * from admin";
		Statement st1=con.createStatement();
		ResultSet rs1=st1.executeQuery(query1);
		boolean status1=false;
		while(rs.next()){
			if(rs.getString(4).equals(email) && rs.getString(7).equals(pass)){
				status=true;
}
}
		while(rs1.next()){
			if(rs1.getString(3).equals(email) && rs1.getString(4).equals(pass)){
				status1=true;
}
}	
	if(status==true){
	System.out.println("\tAgent Logged IN");
	Agent a=new Agent();
	a.agent();
	
}
	if(status1==true){
	System.out.println("\tAdministrator Logged IN");
	Data d=new Data();
	d.admin();
}
	else if(status==false && status1==false){ System.out.println("\tNo Matches Found");
}
}
}
class Test{
	public static void main(String[] args)throws Exception{
	System.out.println("\t***************Welcome To CarsHound****************");
	MD o = new MD();
	Scanner sc=new Scanner(System.in);
	System.out.println("\t\t\t1.Login	2.Registration");
	int c=Integer.parseInt(sc.nextLine());
	switch(c){
	
	case 1:o.login();
	break;
	case 2:o.register();
	break;
	default:System.out.println("\tWrong Selection");
}
	}
}
