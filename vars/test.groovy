import groovy.sql.Sql
import java.util.*
import java.text.SimpleDateFormat 


def dbinsert(String build_name,String user_name,String build_status,String start_date,String end_date){   
  
    def dbURL = 'jdbc:mysql://localhost:3306/buildinfo'
    def dbUserName = 'root'
    def dbPassword = 'pol123@1982M'
    def dbDriver = 'com.mysql.cj.jdbc.Driver'
    def db = Sql.newInstance(dbURL,dbUserName,dbPassword,dbDriver)
    db.connection.autoCommit = false
        
//   def build_name = args[0]
//   def user_name = args[1]
//   def build_status = args[2]
//   def start_date = args[3]
//   def end_date = args[4]
      
     def sqlstr="INSERT INTO build (build_name,user_name, build_status,start_date,end_date) VALUES ('$build_name','$user_name','$build_status', '$start_date','$end_date')"

    println sqlstr

   try {
    db.execute(sqlstr);
    db.commit()
    println("Successfully committed") 
    }

 catch(Exception e){
    db.rollback()
    println("Transaction rollback") 
}finally{
     db.close()
}
   
}

//dbinsert(args[0],args[1],args[2],args[3],args[4])
