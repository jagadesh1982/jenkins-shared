import groovy.sql.Sql
import java.util.*
import java.text.SimpleDateFormat 

    def dbURL = 'jdbc:mysql://localhost:3306/buildinfo'
    def dbUserName = 'root'
    def dbPassword = 'pol123@1982M'
    def dbDriver = 'com.mysql.cj.jdbc.Driver'
    def db = Sql.newInstance(dbURL,dbUserName,dbPassword,dbDriver)
    db.connection.autoCommit = false

 try {		
   println args[0]
   println args[1]
   println args[2]
   Date latestdate = new Date("05/11/2015");
  //  def sqlstr="""INSERT INTO build (build_name,user_name, build_status,start_date,end_date) 
   //       VALUES ('sample1','admin','success',NOW(),NOW())"""
   
   def build_name = args[0]
   def user_name = args[1]
   def build_status = args[2]
   def start_date = latestdate.toString()
   def end_date = latestdate.toString()
		
     def sqlstr="INSERT INTO build (build_name,user_name, build_status,start_date,end_date) VALUES "+ "(${build_name},${user_name},${build_status}, ${start_date},${end_date})"

    db.execute(sqlstr);
    db.commit()
   println("Successfully committed") 
}catch(Exception e){
    db.rollback()
    println("Transaction rollback") 
}finally{
     db.close()
}
