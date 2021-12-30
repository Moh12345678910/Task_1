 import java.sql.SQLException;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.Connection;
 import java.sql.Statement;
 import java.sql.ResultSet;
 
 
 public class Task1 {

	public static void main(String args[]){
	 //declare required type 
		String db_user="mo";
		String db_password="mo";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		java.util.Scanner scan=new java.util.Scanner(System.in);
		System.out.println("Enter the values");
		double MM=Integer.parseInt(scan.nextLine());
		double CM=MM/10;
		double M=CM/100;
		double KM=M/1000;
 	
	 Connection con  = null;
	 PreparedStatement pstmt = null;
	 try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection(url,db_user,db_password);
		String sql =" insert into length_converter (MM,CM,M,KM)values(?,?,?,?)"; 
		pstmt  = con.prepareStatement(sql);
		pstmt.setDouble(1,MM);
		pstmt.setDouble(2,CM);
		pstmt.setDouble(3,M);
		pstmt.setDouble(4,KM);

	    //execute
	    int r = pstmt.executeUpdate();
	    if(r>0){
	    	System.out.println("task inserted");
	    }else{
	    	System.out.println("Task Not inserted");
	    }
	 
	 }catch(ClassNotFoundException e){
	   System.out.println("Driver Not Loaded....." + e.getMessage());
	 }catch(SQLException e){
	   System.out.println("DB ERROR : " +e.getMessage());
	   e.printStackTrace();
	 }catch(Exception e){
	   System.out.println("Other ERROR " + e.getMessage());
	 }finally{
	     //release resoucer
	      if(con!=null){
		          try{
				     con.close();  //#5 close connection 
					}catch(SQLException e){
						System.out.println("DB Con CLosing ERROR : "+ e.getMessage());
				  }//catch
		  }//if
	 }//finally
	 
	  
	  
	}//end main

}//end class