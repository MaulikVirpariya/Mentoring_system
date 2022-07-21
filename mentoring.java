import java.util.*;
import java.math.*;
class HOD1 
{	Scanner sca=new Scanner(System.in);
    void option()
    {	short k;
        
        System.out.print("\n\n\n\t");
        for(int i=0;i<185;i++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t");
        System.out.print("Choose your Option given Below\n\n");
        System.out.println("\n\n\t\t\t 1. Professor");
        System.out.println("\t\t\t 2. Student detail");
        System.out.println("\t\t\t 3.Overview Problems");
        System.out.print("\n\n\n\t");
        for(int j=0;j<185;j++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t Enter Your optaion:: ");
        k=sca.nextShort();
        switch(k)
        {
            case 1:
                edit_prof();
                break;
            case 2:
                edit_student();
                break;
            case 3:
            	mentoring.display_p();
            	break;
            	

        }
    }
    void edit_prof()
    {	System.out.print("\n\n\n\t");
        for(int i=0;i<185;i++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t");
        System.out.println("\n\n\t\t\t 1.Info Professor");
        System.out.println("\t\t\t 2.Allocate group  ");
        System.out.print("\n\n\n\t");
        for(int j=0;j<185;j++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t Enter Your optaion:: ");
        short m=sca.nextShort();
        switch(m)
        {
            case 1:
            {
            		mentoring.display();
            }break;
            case 2:
            {	mentoring.display();
            	mentoring.group();	
            }break;
        }
    }
    void edit_student()
    {
        System.out.print("\n\n\n\t");
        for(int i=0;i<185;i++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t");
        System.out.println("\n\n\t\t\t 1.Student list");
        System.out.println("\t\t\t 2. show All problems");
        System.out.print("\n\n\n\t");
        for(int j=0;j<185;j++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t Enter Your optaion:: ");
        short l=sca.nextShort();
        switch(l)
        {
            case 1:
            {
                mentoring.group();
            }break;
            case 2:
            {
            	mentoring.display_p();
            }break;
        }
    }

}
class Professor
{ 	Scanner sc= new Scanner(System.in);
	String name;
    int id;
    int exp;
    String gp_no;		//Given group for Mentoring
    String course;  //Given Course
    int mentor_id;
    int vote=0;
    public Professor(String name, int id, int exp, String course,int mentor_id)
    {
        this.name = name;
        this.id = id;
        this.exp = exp;
        this.course = course;
        this.mentor_id=mentor_id;
     
    }

     void p_option() 
    {
    	System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("\n\n\n\t");
        for(int i=0;i<185;i++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t");
        System.out.print("Choose your Option goven Below\n\n");
        System.out.println("\n\n\t\t\t 1. Show Problems");
        System.out.println("\t\t\t 2. Solve Problems");
        System.out.print("\n\n\n\t");
        for(int j=0;j<185;j++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t Enter Your optaion:: ");
        int k=sc.nextShort();
        switch(k)
        {
            case 1:
            	 System.out.print("\n\n\n\t\t\t Enter Your Mentor_id:: ");
            	 	int m=sc.nextInt();
            	 	mentoring.S_prob(m);
                break;
            case 2:
                mentoring.solv_problem();
                break;
        }
        
    }
}

class student
{
    String name;
    int roll_no;
    short gp;
    short mentor_id;
    public student(String name, int roll_no,short i) 
    {
    	this.name=name;
    	this.roll_no=roll_no;
    	this.gp=i;
    }
}
class prob extends student
{
	int prob_id;
	String prob;
	String status="Open";
	int mentor_id;
	public prob(String name, int roll_no,short i,String prob, int prob_id,int mentor_id)
	{	super( name, roll_no,i);
		this.prob=prob;
		this.prob_id=prob_id;
		this.mentor_id=mentor_id;
		
	}
	void solved()
	{
		System.out.println("\n\n\t\t\tProblem is Solved");
	}
}

public class mentoring {
    static student[] BCE_19;
    static Professor[] pro;
    static prob[] problem;
    static void setpro(Professor[] pro)
    {		
    	pro[0] = new Professor("Savani Vaghani",52,11,"OOP",1);
        pro[1] = new Professor("Maulik Virpariya",301,5,"Data Strucutre and Algorithm",2);
        pro[2] = new Professor("Yagnik Thummar",302,7,"Digital Communicatin",2);
        pro[3] = new Professor("Utsav Thakkar",303,6,"Discreat Mathamtics",3);
        pro[4] = new Professor("Pratik Thakkar",304,17,"OS",4);
        pro[5] = new Professor("Kautubh Upadhyay",305,6,"Computer Organization and Architecture",5);
        pro[6] = new Professor("Priyank vara",786,15,"Artificial Intelligence",6); 
        Random rand = new Random();
        for(int i = 0 ; i < 300 ; i++)
        {
            int k = rand.nextInt(7);
            mentoring.pro[k].vote++;
        }
        for(int i =0; i<6;i++)
        {
        	for(int j=0;j<6-i;j++)
        	{
        		if(pro[j].vote>pro[j+1].vote)
        		{
        			Professor tem =pro[j];
        			pro[j]=pro[j+1];
        			pro[j+1]=tem;
        		}
        		}
        }
      pro[0].gp_no="A1";
      pro[1].gp_no="A2";
      pro[2].gp_no="A3";
      pro[3].gp_no="B1,B2";
      pro[4].gp_no="B3,C1";
      pro[5].gp_no="C2,C3";
      pro[6].gp_no="D1,D2,D3";
      
      pro[0].mentor_id=501;
      pro[1].mentor_id=502;
      pro[2].mentor_id=503;
      pro[3].mentor_id=504;
      pro[4].mentor_id=505;
      pro[5].mentor_id=506;
      pro[6].mentor_id=507;
    }
    static void setprob(prob[] problem)
    {
    	Random rand=new Random();
    	int k=0;
    	for(int n=0;n<19;n++)
    	{		k=0;
    			k=rand.nextInt(300);
    			
    			if(k>0&&k<=25)problem[n]=new prob("A1",k,(short)1,"Attendance issue",100+n,501);
    			else if(k>25&&k<=50) problem[n]=new prob("A2",k,(short)2,"Attendance issue",100+n,502);
    			else if(k>50&&k<=75) problem[n]=new prob("A3",k,(short)3,"Attendance issue",100+n,503);
    			else if(k>75&&k<=100)problem[n]=new prob("B1",k,(short)4,"Attendance issue",100+n,504);
    			else if(k>100&&k<=125) problem[n]=new prob("B2",k,(short)4,"Attendance issue",100+n,504);
    			else if(k>125&&k<=150) problem[n]=new prob("B3",k,(short)5,"Attendance issue",100+n,505);
    			else if(k>150&&k<=175) problem[n]=new prob("C1",k,(short)6,"Attendance issue",100+n,505);
    			else if(k>175&&k<=200)problem[n]=new prob("C2",k,(short)7,"Attendance issue",100+n,506);
    			else if(k>200&&k<=225)problem[n]=new prob("C3",k,(short)8,"Attendance issue",100+n,506);
    			else if(k>225&&k<=250) problem[n]=new prob("D1",k,(short)9,"Attendance issue",100+n,507);
    			else if(k>250&&k<=275) problem[n]=new prob("D2",k,(short)10,"Attendance issue",100+n,507);
    			else if(k>275&&k<=300)problem[n]=new prob("D3",k,(short)11,"Attendance issue",100+n,507);
    	}
    	for(int n=19;n<25;n++)
    	{		k=0;
    			k=rand.nextInt(300);
    		
    			if(k>0&&k<=25)problem[n]=new prob("A1",k,(short)1,"Want 2 days leave",100+n,501);
    			else if(k>25&&k<=50) problem[n]=new prob("A2",k,(short)2,"Want 4 days leave",100+n,502);
    			else if(k>50&&k<=75) problem[n]=new prob("A3",k,(short)3,"Regarding circtificate",100+n,503);
    			else if(k>75&&k<=100)problem[n]=new prob("B1",k,(short)4,"Want 2 days leave",100+n,504);
    			else if(k>100&&k<=125) problem[n]=new prob("B2",k,(short)4,"Regarding Missbehavior",100+n,504);
    			else if(k>125&&k<=150) problem[n]=new prob("B3",k,(short)5,"Class bunk",100+n,505);
    			else if(k>150&&k<=175) problem[n]=new prob("C1",k,(short)6,"Cantaing fight",100+n,505);
    			else if(k>175&&k<=200)problem[n]=new prob("C2",k,(short)7,"Regarding circtificate",100+n,506);
    			else if(k>200&&k<=225)problem[n]=new prob("C3",k,(short)8,"Regarding Missbehavior",100+n,506);
    			else if(k>225&&k<=250) problem[n]=new prob("D1",k,(short)9,"Want 2 days leave",100+n,507);
    			else if(k>250&&k<=275) problem[n]=new prob("D2",k,(short)10,"Class bunk",100+n,507);
    			else if(k>275&&k<=300)problem[n]=new prob("D3",k,(short)11,"Event announcement",100+n,507);
    			
    	}
    	}
    static void display_p()
    {	
	   for(int i=0;i<25;i++)
        {
    	System.out.println("\n\n\t\t\t Name of Student:"+problem[i].name);
    	System.out.println("\t\t\t Roll number:"+problem[i].roll_no);
    	System.out.println("\t\t\t Group ID:"+problem[i].gp);
    	System.out.println("\t\t\t Problem:"+problem[i].prob);
    	System.out.println("\t\t\t Problem number:"+problem[i].prob_id);
    	System.out.println("\t\t\t Problem Status:"+problem[i].status);
    	}
    }
   static void S_prob(int m)
    {
    	for(int i=0;i<25;i++)
    	{
    		if(problem[i].mentor_id==m)
    		{
    			System.out.println("\n\n\t\t\t Name of Student:"+problem[i].name);
    	    	System.out.println("\t\t\t Roll number:"+problem[i].roll_no);
    	    	System.out.println("\t\t\t Group ID:"+problem[i].gp);
    	    	System.out.println("\t\t\t Problem:"+problem[i].prob);
    	    	System.out.println("\t\t\t Problem number:"+problem[i].prob_id);
    	    	System.out.println("\t\t\t Problem Status:"+problem[i].status);
    		}
    	}
    }
    static void setstu(student[] BCE_19)
    {
    	for(int i=0;i<300;i++)
    	{	if(i<=25&&i>0)
    		{BCE_19[i]=new student("A1",i+1,(short)1);}
    	else if(i<=50&&i>25)
		{BCE_19[i]=new student("A2",i+1,(short)2);}
    	else if(i<=75&&i>50)
		{BCE_19[i]=new student("A3",i+1,(short)3);}
    	else if(i<=100&&i>75)
		{BCE_19[i]=new student("B1",i+1,(short)4);}
    	else if(i<=125&&i>100)
		{BCE_19[i]=new student("B2",i+1,(short)5);}
    	else if(i<=150&&i>125)
    	{BCE_19[i]=new student("B3",i+1,(short)6);}
    	else if(i<=175&&i>150)
    	{BCE_19[i]=new student("C1",i+1,(short)7);}
    	else if(i<=200&&i>175)
    	{BCE_19[i]=new student("C2",i+1,(short)8);}
    	else if(i<=225&&i>200)
		{BCE_19[i]=new student("C3",i+1,(short)9);}
    	else if(i<=250&&i>225)
    	{BCE_19[i]=new student("D1",i+1,(short)10);}
    	else if(i<=275&&i>250)
    	{BCE_19[i]=new student("D2",i+1,(short)11);}
    	else if(i<=300&&i>275)
    	{BCE_19[i]=new student("D3",i+1,(short)12);}
    	}
    
    }
    static void group()
    {	System.out.println("\n\n\t\t\t There are total 12 groups.");
    	for(int i=1;i<300;)
    	{	
    		System.out.println("\t\t\t group code "+BCE_19[i].name+" total 25 students are there and group no. is "+BCE_19[i].gp);
    		i=i+25;
    	}
    }
      static void display()
    {	
	   for(int i=0;i<7;i++)
        {
    	System.out.println("\n\n\t\t\t Name of proffesir:"+pro[i].name);
    	System.out.println("\t\t\t ID of proffesir:"+pro[i].id);
    	System.out.println("\t\t\t Experince of proffesir:"+pro[i].exp);
    	System.out.println("\t\t\t Specialied Course:"+pro[i].course);
    	if(pro[i].gp_no!="NUll")
    	{
    		System.out.println("\t\t\t He/She id mentring group number :"+pro[i].gp_no);
    	}
    	if(pro[i].vote!=0)
    	{
    		System.out.println("\t\t\t He got :"+pro[i].vote+" vote from students.");
    	}
        }
    }
     static void solv_problem()
     {
    	 mentoring.solv_prob(problem);
     }
     static void  solv_prob(prob[] problem)
      {		Scanner sc=new Scanner(System.in);
    	 	System.out.print("\n\n\t\t\t Enter Your Mentor Id::");
      		int m=sc.nextInt();
    	    mentoring.S_prob(m);
    	    System.out.print("\n\n\t\t Enter problem number:: ");
    	    int p=sc.nextInt();
    	    for(int i=0;i<25;i++)
    	    {
    	    	if(problem[i].prob_id==p)
    	    	{
    	    		System.out.println("\n\n\t\t If it is solved then press 1");
    	    		short k=sc.nextShort();
    	    		if(k==1)
    	    		{
    	    			problem[i].status="Close";
    	    		}
    	    	}
    	    }
      sc.close();}
    public static void main(String[] args)
    {	Scanner sc= new Scanner(System.in);
        int i;
        pro= new Professor[7];
        BCE_19= new student[300];
        problem=new prob[30];
        setstu(BCE_19);
        setpro(pro);
        setprob(problem);
        for(int k=0;k!=4;)
         {
            System.out.print("\n\n\n\t");
            for(i=0;i<185;i++)
                System.out.print("#");
            System.out.print("\n\n\n\t\t\t");
            System.out.print("Choose your Option goven Below\n\n");
            System.out.println("\n\n\t\t\t 1.Head Of Department");
            System.out.println("\t\t\t 2.Professior");
            System.out.println("\t\t\t 3.Student");
            System.out.println("\t\t\t 4.exit");
            System.out.print("\n\n\n\t");
            for(i=0;i<185;i++)
                System.out.print("#");
            System.out.print("\n\n\n\t\t\t Enter Your optaion:: ");
            i=sc.nextInt();
            switch(i)
            {
                case 1:
                {	HOD1	hod1= new HOD1();
                    String code="cse2020";
                    System.out.print("\n\n\n\t\t\t Enter Your HOD code here::");
                    String code1=sc.next();
                    boolean mcode = code.equals(code1);
                    while(mcode==false)
                    {
                        System.out.print("\n\n\t\t\t::Enter a valide code::");
                        System.out.print("\n\n\n\t\t\t Enter Your HOD code here::");
                        code1=sc.next();
                        mcode = code.equals(code1);
                    }
                    hod1.option();
                }break;
                
                case 2:
                {
                	pro[0].p_option();
                }break;
                case 3:
                {
                	System.out.print("\n\n\n\t");
                    for(i=0;i<185;i++)
                        System.out.print("#");
                    System.out.print("\n\n\n\t\t\t");
                    System.out.print("\n\n\t\t\t If you want to see all problem press 1\n\n\t\t::");
                    short o=sc.nextShort();
                    if(o==1)
                    mentoring.display_p();
                    System.out.print("\n\n\t\t\t If you want to creat new problem press 1\n\n\t\t::");
                    short t=sc.nextShort();
                    if(t==1)
                    {
                    	System.out.print("\n\n\t\t\t Enter your roll number followed by !9BCEXX:: ");
                    	int roll=sc.nextInt();
                    	System.out.print("\n\n\t\t\t Name of Student:");
                    	String name=sc.next();
                    	System.out.print("\n\t\t\t Group ID:");
            	    	short r=sc.nextShort();
                    	System.out.print("\n\t\t\t Problem:");
                    	String problem=sc.next();
            	    	System.out.print("\n\t\t\t Problem number(Last +1):");
            	    	int probno=sc.nextInt();
            	    	System.out.print("\n\t\t\t Enter your mentor id:");
            	    	int mentorid=sc.nextInt();
            	    	prob p1=new prob(name,roll,r,problem,probno,mentorid);
                   
                    }
                }break;
                case 4:
                {System.out.println("\n\n\t\t\tPress 1 for exit\n\n\t\t::");
                int p=sc.nextInt();
                if(p==1)
                {
                    k=4;
                }break;
                	
                }
                default :
                {
                    System.out.println("\n\n\n\t\t\t Enter valid input");
                 
                System.out.print("\n\n\t\t\tPress 1 for continue\n\n\t\t::");
                int p=sc.nextInt();
                if(p==1)
                {
                    k=0;
                }else k=4;
                }
            }
        }System.out.print("\n\n\n\t");
        for(i=0;i<185;i++)
            System.out.print("#");
        System.out.print("\n\n\n\t\t\t");
        System.out.println("\n\n\t\t\t Thank You, Have A Great Day");
        sc.close();}


}