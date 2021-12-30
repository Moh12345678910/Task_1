
 import java.sql.SQLException;
 import java.sql.DriverManager;
 import java.sql.Connection;
 import java.sql.Statement;
 import java.sql.ResultSet;
 
 
 
 public class Task2 {

	public static void main(String args[]){
	 //declare required type 
      ResultSet rs=null;
	 Connection con  = null;
	 Statement stmt = null;
		String user="mo";
		String password="mo";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
	
	 try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection(url,user,password);
		stmt  = con.createStatement();
		String sql=" select * from length_converter" ; 
     	 rs  =  stmt.executeQuery(sql);
			while( rs.next()){
			  double MM = rs.getDouble("MM");
			  double CM = rs.getDouble("CM");
			  double M = rs.getDouble("M");
			  double KM = rs.getDouble("KM");
			  System.out.println("MM ="+MM+", CM = "+CM+", M = "+M+", KM = "+KM);
			}
		//******************************************
		
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
						System.out.println("#5 connection closed");
					}catch(SQLException e){
						System.out.println("DB Con CLosing ERROR : "+ e.getMessage());
				  }//catch
		  }//if
	 }//finally
	 
	  
	  
	}//end main

}//end class