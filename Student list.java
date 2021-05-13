package datastructures;
import java.util.Scanner;
import java.io.File;
public class Assignment3 {

	

	

	
	    public static class Student{
	        public int student_number;
	        public double marks;
	        public Student next;

	     
	        Student(int id, double score){
	            marks = score;
	            student_number = id;
	        }

	    }


	   
	    public static class studentList{
	        public Student head;

	      
	        studentList(){
	            head = null;
	        }


	     // this the how we add a new node in a sorted linked list
	        public void insert(int id, double score){ 

	            
	            Student new_node = new Student(id, score);

	            
	            Student current = head, temp = null;

	            while(current != null && current.marks > score){
	                temp = current;    
	                current = current.next;
	            }

	         
	            if(current == head){

	                new_node.next = head;
	                head = new_node;
	            }
	            else{

	                //insert the node between temp and current
	                temp.next = new_node;
	                new_node.next = current;
	            }

	        }


	        
	        public void printList(){
	            System.out.println("Student Number:\t\t\t\tMark:");
	           
	            
	            Student temp = head;

	            while(temp != null){
	                System.out.println(String.valueOf(temp.student_number) + "\t\t\t\t\t" + String.valueOf(temp.marks));
	                temp = temp.next;
	            }
	        }


	       
	        public Student getMedian(Student slow, Student fast){

	            if(fast.next == null || fast.next.next == null)
	                return slow;
	            
	            return getMedian(slow.next, fast.next.next); 
	        }

	    }

	  
	   
	    public static void main(String[] args) throws Exception{
	        
	        
	        studentList s = new studentList();


	        
	        File data_file = new File("test2.txt"); 
	        Scanner sc = new Scanner(data_file); 
	    
	       
	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
                String temp[]= line.split(" ");
	           
	            int stud_num = Integer.parseInt(temp[0]); // parseInt and valueOf works same.
	            double marks = Double.valueOf(temp[1]);

	            
	            s.insert(stud_num, marks);

	        }

	       
	        s.printList();

	     
	        Student median_stud = s.getMedian(s.head, s.head);

	        System.out.println("\n\nthe median mark is " + String.valueOf(median_stud.marks) + " by student number " + String.valueOf(median_stud.student_number));
	       
	    }
	
}
