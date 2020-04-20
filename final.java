import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.io.*;

class RollnoException extends Exception		//User defined exception which raises if roll number is not found
{
	int rno;
	RollnoException(int r)
	{
		rno=r;
	}
	public String toString()
	{
		return("The entered roll number "+rno+" is not present");
	}
}



class teacher
{
String username ="aishwarya";
String password="1010";
Scanner obj1 = new Scanner(System.in);
ArrayList<Integer> stu_roll = new ArrayList<Integer>(10);
ArrayList<String> stu_name = new ArrayList<String>(10);
ArrayList<Integer> stu_atten = new ArrayList<Integer>(10);
ArrayList<Integer> stu_marks1 = new ArrayList<Integer>(10);
ArrayList<Integer> stu_marks2 = new ArrayList<Integer>(10);
ArrayList<Integer> stu_marks3 = new ArrayList<Integer>(10);
ArrayList<Integer> stu_marks4 = new ArrayList<Integer>(10);
ArrayList<Integer> stu_totmarks = new ArrayList<Integer>(10);
ArrayList<String> stu_homework= new ArrayList<String>(10);
ArrayList<String> teach_message = new ArrayList<String>(10);
ArrayList<String> stu_query = new ArrayList<String>(10);


void teacher_log()
{
 System.out.println("------------------------------LOG IN------------------------------ \n");
 System.out.println("Enter username  :::::for ur reference it is -'aishwarya'::::::::\n:");
 String user = obj1.next();
  System.out.println("Enter password: :::::for ur reference it is -'1010'::::::::\n");
  String pass = obj1.next();
  if(user.equals(username) && pass.equals(password)){
 System.out.println("You are logged in successfully. \n");
 this.teacher_menu();
}
else{
System.out.println("Enter the correct credentials \n");
this.teacher_log();
}
}


void teacher_menu()
{
System.out.println("---------------------------------------------------------------------\n");
System.out.println("Press 1 to check the detail of all student\n");
System.out.println("Press 2 to check the detail of one students\n");
System.out.println("Press 3 to see the students with less attendance\n");
System.out.println("Press 4 to update the attendance of any student\n");
System.out.println("Press 5 to update the marks of any student\n");
System.out.println("Press 6 to add OR replace the details of new student\n");
System.out.println("Press 7 to remove the student from school\n");
System.out.println("Press 8 to assign homework to student/s\n");
System.out.println("Press 9 to see requests or query given by students\n");
System.out.println("Press 10 to respond to queries\n");
System.out.println("Press 11 to go to the students portal\n");
System.out.println("Press 12 to exit\n");
System.out.println("---------------------------------------------------------------------\n");
int menu =obj1.nextInt();
switch(menu){
case 1:
   all_detail();
   teacher_menu();
   break;
   
case 2:
   one_detail();
   teacher_menu();
   break;
   
case 3:
   less_atten();
   teacher_menu();
   break;   
   
case 4:
   update_atten();
   teacher_menu();
   break;   

case 5:
   update_marks();
   teacher_menu();
   break;
   
case 6:
   add_info();
   teacher_menu();
   break;
   
case 7:
   del_info();
   teacher_menu();
   break;   
      
case 8:
   teacher_homework();
   teacher_menu();
   break;
   
case 9:
   teacher_query();
   teacher_menu();
   break;

case 10:
   teacher_message();
   teacher_menu();
   break;
   
case 11:
   student_info();
   break;
case 12:
   System.out.println("------------------------------------------------------------------------------------------------------");
   System.out.println("                                               EXIT                                                   ");
   System.out.println("------------------------------------------------------------------------------------------------------");
   break;  
   
default:
      System.out.println("PLEASE ENTER A NUMBER BETWEEN 1-10 \n");
      teacher_menu();
     }
}





void all_detail()
{
for(int i=0;i<stu_roll.size();i++)
{
System.out.println("------------------------------------------------------------------------------------------------------");
System.out.println("ROLL NO.-                "+stu_roll.get(i)+"\n");
System.out.println("NAME-                    "+stu_name.get(i)+"\n");
System.out.println("CURRENT ATTENDANCE-      "+stu_atten.get(i)+"\n");
System.out.println("MARKS IN SUBJECT 1-      "+stu_marks1.get(i)+"\n");
System.out.println("MARKS IN SUBJECT 2-      "+stu_marks2.get(i)+"\n");
System.out.println("MARKS IN SUBJECT 3-      "+stu_marks3.get(i)+"\n");
System.out.println("MARKS IN SUBJECT 4-      "+stu_marks4.get(i)+"\n");
System.out.println("TOTAL MARKS-             "+stu_totmarks.get(i)+"\n");
System.out.println("------------------------------------------------------------------------------------------------------");

}
}
public void one_detail()
{
System.out.println("Enter the Roll number to get the details( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{
				if(search_rno(rollno)){throw new RollnoException(rollno);}
					System.out.println("STUDENT'S ROLL NO.-     "+stu_roll.get(rollno-1));
          System.out.println("STUDENTS'S NAME -       "+stu_name.get(rollno-1));
          System.out.println("STUDENT'S ATTENDANCE -  "+stu_atten.get(rollno-1)); 
          System.out.println("SUBJECT 1 MARKS -       "+stu_marks1.get(rollno-1));
          System.out.println("SUBJECT 2 MARKS -       "+stu_marks2.get(rollno-1));
          System.out.println("SUBJECT 3 MARKS -       "+stu_marks3.get(rollno-1)); 
          System.out.println("SUBJECT 4 MARKS -       "+stu_marks4.get(rollno-1)); 
          System.out.println("TOTAL MARKS ARE -       "+stu_totmarks.get(rollno-1));
                
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled..............."+rne);				
				}				
}
void one_detail(int n)
{
				try
				{
				if(search_rno(n)){throw new RollnoException(n);}
					System.out.println("STUDENT'S ROLL NO. -      "+stu_roll.get(n-1));
          System.out.println("STUDENTS'S NAME -         "+stu_name.get(n-1));
          System.out.println("STUDENT'S ATTENDANCE -    "+stu_atten.get(n-1)); 
          System.out.println("SUBJECT 1 MARKS -         "+stu_marks1.get(n-1));
          System.out.println("SUBJECT 2 MARKS -         "+stu_marks2.get(n-1));
          System.out.println("SUBJECT 3 MARKS -         "+stu_marks3.get(n-1)); 
          System.out.println("SUBJECT 4 MARKS -         "+stu_marks4.get(n-1)); 
          System.out.println("TOTAL MARKS ARE -         "+stu_totmarks.get(n-1));
                
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}				
}
void less_atten()
{
System.out.println("PRINTING ROLL NO AND NAMES OF STUDENTS WHO HAVE ATTENDANCE LESS THAN 75 % ");
for (int i=0;i<stu_roll.size();i++){
      if(stu_atten.get(i)<75)
         {
         System.out.println( "ROLL NO -      "+stu_roll.get(i) +"         NAME-        "+stu_name.get(i)+"         CURRENT ATTENDANCE        "+stu_atten.get(i)+"\n");
         }
}
}

void update_atten()
{
System.out.println("Enter the Roll number of the student ( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{
				if(search_rno(rollno-1)){throw new RollnoException(rollno);}
				  System.out.println("ENTER THE NEW ATTENDANCE");
				  int new_r=obj1.nextInt();
          stu_atten.set(rollno-1,new_r);
          System.out.println("ATTENDANCE SUCESSFULLY UPDATED ....!!!!!!!"); 
        	}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}
}

void update_marks()
{
System.out.println("Enter the Roll number of the student ( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{
				if(search_rno(rollno-1)){throw new RollnoException(rollno);}
				  System.out.println("ENTER THE UPDATED MARKS OF SUBJECT 1");
				  int new_m1=obj1.nextInt();
          stu_marks1.set(rollno-1,new_m1);
          
          System.out.println("ENTER THE UPDATED MARKS OF SUBJECT 2");
				  int new_m2=obj1.nextInt();
          stu_marks2.set(rollno-1,new_m2);
          
          System.out.println("ENTER THE UPDATED MARKS OF SUBJECT 3");
				  int new_m3=obj1.nextInt();
          stu_marks3.set(rollno-1,new_m3);
          
          System.out.println("ENTER THE UPDATED MARKS OF SUBJECT 4");
				  int new_m4=obj1.nextInt();
          stu_marks4.set(rollno-1,new_m4);
          
          int new_tot=new_m1+new_m2+new_m3+new_m4;
          stu_totmarks.set(rollno-1,new_tot);
          System.out.println("MARKS SUCESSFULLY UPDATED ....!!!!!!!"); 
        	}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}
}

void add_info()
{

System.out.println("Enter the roll no. whose details are to be added");
int rolll=obj1.nextInt();
if(rolll>10){
System.out.println("CURRENT CAPACITY OF THE SCHOOL IS 10 STUDENTS ONLY");
teacher_menu();
}

int roll=rolll;
stu_roll.set(roll-1,roll);

System.out.println("Enter the name");
String name=obj1.next();
stu_name.set(roll-1,name);

System.out.println("Enter the attendance");
int atten=obj1.nextInt();
stu_atten.set(roll-1,atten);

System.out.println("Enter the marks in subject 1");
int mark1=obj1.nextInt();
stu_marks1.set(roll-1,mark1);

System.out.println("Enter the marks in subject 2");
int mark2=obj1.nextInt();
stu_marks2.set(roll-1,mark2);

System.out.println("Enter the marks in subject 3");
int mark3=obj1.nextInt();
stu_marks3.set(roll-1,mark3);

System.out.println("Enter the marks in subject 4");
int mark4=obj1.nextInt();
stu_marks4.set(roll-1,mark4);

int total_marks=mark1+mark2+mark3+mark4;
stu_totmarks.set(roll-1,total_marks);

System.out.println("the details are added \n");
}

void del_info()
{
System.out.println("Enter the Roll number of the student ( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{if(search_rno(rollno))
				{throw new RollnoException(rollno-1);}
				  stu_roll.remove(rollno-1);
          stu_name.remove(rollno-1);
          stu_atten.remove(rollno-1); 
          stu_marks1.remove(rollno-1);
          stu_marks2.remove(rollno-1);
          stu_marks3.remove(rollno-1); 
          stu_marks4.remove(rollno-1); 
          stu_totmarks.remove(rollno-1);
          stu_query.remove(rollno-1);
          stu_homework.remove(rollno-1);
          teach_message.remove(rollno-1);
                
          System.out.println("RECORD SUCESSFULLY DELETED ....!!!!!!!"); 
        	}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}
}

void teacher_homework()
{
System.out.println("ENTER THE HOMEWORK TO BE ASSIGNED");
obj1.nextLine();
String home=obj1.nextLine();
for (int i=0;i<stu_roll.size();i++)
{
stu_homework.set(i,home);
}
}

void teacher_query()
{
System.out.println(stu_query);
}

void teacher_message()
{
System.out.println("ENTER THE ROLL NO OF THE STUDENT TO WHOM MESSAGE HAS TO BE SENT");
int rolll=obj1.nextInt();

System.out.println("ENTER THE MESSAGE TO BE SENT");
obj1.nextLine();
String msg=obj1.nextLine();

teach_message.set(rolll-1,msg);
System.out.println("THE MESSAGE SENT SUCCESSFULLY");
}

void see_homework()
{
System.out.println("Enter the Roll number to get the details( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{
				if(search_rno(rollno)){throw new RollnoException(rollno);}
					
          System.out.println(stu_homework.get(rollno-1));
                
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}	
}
void see_homework(int m)
{
				try
				{
				if(search_rno(m)){throw new RollnoException(m);}
					
          System.out.println(stu_homework.get(m-1));
                
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}	
}
void student_message(){
System.out.println("Enter the Roll number to get the details( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{
				if(search_rno(rollno)){throw new RollnoException(rollno);}
					
          System.out.println("YOUR MESSAGE IS \n"+teach_message.get(rollno-1));
                
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}	

}
void student_message(int m){
				try
				{
				if(search_rno(m)){throw new RollnoException(m);}
					
          System.out.println("YOUR MESSAGE IS \n"+teach_message.get(m-1));
                
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}	

}
void student_query(){
System.out.println("Enter the Roll number( PLEASE ENTER A VALID ONE ):\n");
				int rollno=obj1.nextInt();
				try
				{
				if(search_rno(rollno)){throw new RollnoException(rollno);}
					System.out.println("ENTER YOUR Query");
					obj1.nextLine();
          String ques=obj1.nextLine();
          stu_query.set(rollno-1,ques);
        }
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}	
}

void student_query(int m){
				try
				{
				if(search_rno(m)){throw new RollnoException(m);}
					System.out.println("ENTER YOUR Query");
					obj1.nextLine();
          String ques=obj1.nextLine();
          stu_query.set(m-1,ques);       
				}
				catch(RollnoException rne)
				{
					System.out.println("Exception Handled...."+rne);				
				}	
}
void student_info(){
System.out.println("ENTER YOUR ROLL NO. \n");
int ro =obj1.nextInt();
System.out.println("PRESS 1 IF YOU WANT TO VIEW DETAILS \n PRESS 2 TO ADD A QUERY \n PRESS 3 TO SEE THE TEACHER'S MESSAGE \n PRESS 4 TO VIEW HOMEWORK \n PRESS 5 TO GO TO TEACHER'S PORTAL \n PRESS 6 TO EXIT \n");
int sel=obj1.nextInt();
switch(sel)
{
case 1:
one_detail(ro);
student_info();
break;

case 2:
student_query(ro);
student_info();
break; 

case 3:
student_message(ro);
student_info();
break; 

case 4:
see_homework(ro);
student_info();
break; 

case 5:
teacher_log();

case 6:
System.out.println("------------------------------------------------------------------------------------------------------");
System.out.println("                                               EXIT                                                   ");
System.out.println("------------------------------------------------------------------------------------------------------");
break; 

default:
System.out.println("wrong number entered");
student_info();
}
}

void poll()
{
System.out.println(" Enter 1 if you are a student and enter 2 if you are a teacher");
int n1=obj1.nextInt();

if(n1==1)
{
this.student_info();

}
else if(n1==2)
{
this.teacher_log();

}
else{
System.out.println(" You have to enter a digit either 1 or 2");
this.poll();
}
}

public static void main(String args[])
{
Scanner obj1 = new Scanner(System.in);

teacher ooo=new teacher();

for(int i=0;i<10;i++){
          ooo.stu_roll.add(0);
          ooo.stu_name.add("NULL");
          ooo.stu_atten.add(0); 
          ooo.stu_marks1.add(0);
          ooo.stu_marks2.add(0);
          ooo.stu_marks3.add(0); 
          ooo.stu_marks4.add(0); 
          ooo.stu_totmarks.add(0);
          ooo.stu_query.add("NULL");
          ooo.stu_homework.add("NULL");
          ooo.teach_message.add("NULL");
}
 ooo.poll();


}
boolean search_rno(int r)	//Checks if the given roll number is present in the input array
	{ 
	int flag=0;	
		for (int i=0;i<stu_roll.size();i++){
		if(stu_roll.get(i)==r){
			flag++;
			break;}
		else
		  flag=0;
		  }	
		if(flag==0)
			return true;
		else
			return false;
	}
}






