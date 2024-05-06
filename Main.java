import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        Placement placement = new Placement();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Student> registeredPlacementStudents = new ArrayList<Student>();
        ArrayList<Company> companies = new ArrayList<Company>();
        Scanner x = new Scanner(System.in);
        String EnterString = x.next();
        if(EnterString.equals("Enter")){
            while(true){
                System.out.println("Welcome to FutureBuilder:");
                System.out.println("    1) Enter the Application");
                System.out.println("    2) Exit the Application");

                int i = x.nextInt();
                if(i==2){
                    String exit = x.next();
                    if(exit.equals("Exit")){
                        System.out.println("Thanks for using FutureBuilder");
                        break;
                    }
                }
                if (i==1){
                    while(true){
                        System.out.println("Choose the mode you want to Enter in:-");
                        System.out.println("    1) Enter as Student Mode");
                        System.out.println("    2) Enter as Company Mode");
                        System.out.println("    3) Enter as Placement Cell Mode");
                        System.out.println("    4) Return to Main Application");
                        int j = x.nextInt();
                        if(j==4){
                            break;
                        }
                        if(j==1){
                            while(true){
                                System.out.println("Choose the Student Query to perform-");
                                System.out.println("    1) Enter as a Student(Give Student Name, and Roll No");
                                System.out.println("    2) Add students");
                                System.out.println("    3) Back");
                                int k = x.nextInt();
                                if(k==3){
                                    break;
                                }
                                if(k==2){
                                    System.out.println("Number of students to add");
                                    int no = x.nextInt();
                                    System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
                                    for (int p = 0; p<no;p++){
                                        Student s1 = new Student();
                                        String Name = x.next();
                                        int RollNo = x.nextInt();
                                        float CGPA = x.nextFloat();
                                        String Branch = x.next();
                                        s1.StudentInfo(Name, RollNo, CGPA, Branch);
                                        students.add(s1);
                                    }
//                            Student s1 = new Student();
//                            Student s2 = new Student();
//                            Student s3 = new Student();
//                            String Name = x.next();
//                            int RollNo = x.nextInt();
//                            float CGPA = x.nextFloat();
//                            String Branch = x.next();
//                            s1.StudentInfo(Name, RollNo, CGPA, Branch);
//                            String Name1 = x.next();
//                            int RollNo1 = x.nextInt();
//                            float CGPA1 = x.nextFloat();
//                            String Branch1 = x.next();
//                            s2.StudentInfo(Name1, RollNo1, CGPA1, Branch1);
//                            String Name2 = x.next();
//                            int RollNo2 = x.nextInt();
//                            float CGPA2 = x.nextFloat();
//                            String Branch2 = x.next();
//                            s3.StudentInfo(Name2, RollNo2, CGPA2, Branch2);
//                            students.add(s1);
//                            students.add(s2);
//                            students.add(s3);

                                }
                                if(k==1){
                                    String Name = x.next();
                                    int RollNo = x.nextInt();
                                    for(int q = 0 ; q< students.size();q++){
                                        if(students.get(q).Name.equals(Name)){
                                            while(true){
                                                System.out.println("Welcome "+Name+"!!");
                                                System.out.println("    1) Register For Placement Drive");
                                                System.out.println("    2) Register For Company");
                                                System.out.println("    3) Get All available companies");
                                                System.out.println("    4) Get Current Status");
                                                System.out.println("    5) Update CGPA");
                                                System.out.println("    6) Accept offer");
                                                System.out.println("    7) Reject offer");
                                                System.out.println("    8) Back");
                                                int s = x.nextInt();
                                                if(s==3){
                                                    students.get(q).getCompanies(company);
                                                }
                                                if(s==1){
                                                    registeredPlacementStudents.add(students.get(q));
                                                    java.util.Date date = new java.util.Date();
                                                    System.out.println(date);
                                                    System.out.println(Name+" Registered for the Placement Drive at IIITD!!!!");
                                                    System.out.println("Your details are:");
                                                    students.get(q).PrintDetails();
                                                }
                                                if(s==2){
                                                    for(int g = 0;g<companies.size();g++){
                                                        System.out.println((g+1)+") "+companies.get(g).Name);
                                                    }
                                                    if(students.get(q).RegisterCompany(companies.get(0)).equals("Applied")){
                                                        System.out.println("Successfully registered for "+companies.get(0).Role+" Role at "+companies.get(0).Name);
                                                        company.getSelectedStudents(students.get(q));
                                                    }
                                                }
                                                if(s==4){
                                                    students.get(q).getStatus(companies.get(0));
                                                    if(students.get(q).getStatus(companies.get(0)).equals("Offered")){
                                                        System.out.println("You have been offered by "+company.Name+"!! Please accept the offer");
                                                    }
                                                }
                                                if(s==5){
                                                    float NewCG = x.nextFloat();
                                                    students.get(q).UpdateCGPA(placement,NewCG);
                                                }
                                                if(s==6){
                                                    students.get(q).Accept(companies.get(0));
                                                    System.out.println("Congratulations "+students.get(q).Name+"!!! You have accepted the offer by "+company.Name+"!!");
                                                }
                                                if(s==7){
                                                    students.get(q).Reject();
                                                }
                                                if(s==8){
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        if(j==2){
                            while(true){
                                System.out.println("Choose the company query to perform:-");
                                System.out.println("    1) Add Company and Details");
                                System.out.println("    2) Choose Company");
                                System.out.println("    3) Get Available Companies");
                                System.out.println("    4) Back");
                                int b = x.nextInt();
                                if(b==1){
                                    String Name = x.next();
                                    String Role = x.next();
                                    float CTC = x.nextFloat();
                                    float CG = x.nextFloat();
                                    company.CompanyInfo(Name, Role, CTC, CG);   //have to do company yet
                                    companies.add(company);
                                }
                                if(b==2){
                                    System.out.println("Choose to enter into mode of Available Companies:-");
                                    for(int c=0; c<companies.size(); c++){
                                        System.out.println((c+1)+") "+companies.get(c).Name);
                                    }
                                    int d = x.nextInt();
                                    System.out.println("Welcome "+companies.get(d-1).Name);
                                    while(true){
                                        System.out.println("    1) Update Role");
                                        System.out.println("    2) Update Package");
                                        System.out.println("    3) Update CGPA criteria");
                                        System.out.println("    4) Register to Institute Drive");
                                        System.out.println("    5) Back");
                                        int e = x.nextInt();
                                        if(e==1){
                                            String Role = x.next();
                                            company.UpdateRole(Role);
                                            companies.set(d-1,company);
                                        }
                                        if(e==2){
                                            float CTC = x.nextFloat();
                                            company.UpdatePackage(CTC);
                                            companies.set(d-1,company);
                                        }
                                        if(e==3){
                                            float CG = x.nextFloat();
                                            company.UpdateCGPA(CG);
                                            companies.set(d-1,company);
                                        }
                                        if(e==4){
                                            company.RegisterToInstituteDrive(company);
                                        }
                                        if(e==5){
                                            break;
                                        }
                                    }
                                }
                                if(b==3){
                                    for(int c=0; c<companies.size(); c++) {
                                        System.out.println((c + 1) + ") " + companies.get(c).Name);
                                    }
                                }
                                if(b==4){
                                    break;
                                }
                            }
                        }
                        if(j==3){
                            while(true){
                                System.out.println("Welcome to IIITD Placement Cell");
                                System.out.println("    1) Open Student Registrations");
                                System.out.println("    2) Open Company Registrations");
                                System.out.println("    3) Get Number of Student Registrations");
                                System.out.println("    4) Get Number of Company Registrations");
                                System.out.println("    5) Get Number of Offered/UnOffered/Blocked Students");
                                System.out.println("    6) Get Student Details");
                                System.out.println("    7) Get Company Details");
                                System.out.println("    8) Get Average Package");
                                System.out.println("    9) Get Company Process Results");
                                System.out.println("    10) Back");
                                int f = x.nextInt();
                                if(f==1){
                                    System.out.println("Fill in the details:-");
                                    System.out.println("    1) Set the Opening time for student registrations");
                                    System.out.println("    2) Set the Closing time for student registrations");
                                    int a = x.nextInt();
                                    if(a==1){
                                        placement.OpenCompanyRegistrations();
                                    }
                                    if(a==2){
                                        placement.CloseCompanyRegistrations();
                                    }
                                }
                                if(f==2){
                                    System.out.println("Fill in the details:-");
                                    System.out.println("    1) Set the Opening time for company registrations");
                                    System.out.println("    2) Set the Closing time for company registrations");
                                    int a = x.nextInt();
                                    if(a==1){
                                        placement.OpenCompanyRegistrations();
                                    }
                                    if(a==2){
                                        placement.CloseCompanyRegistrations();
                                    }
                                }
                                if(f==3){
                                    System.out.println(registeredPlacementStudents.size());
                                }
                                if(f==4){
                                    System.out.println(company.RegisteredCompanies.size());
                                }
                                if(f==5){
                                    int unOffered=0;
                                    int blocked=0;
                                    for(int h= 0; h<students.size(); h++){
                                        if(students.get(h).Status.equals("UnOffered")){
                                            unOffered+=1;
                                        }
                                        if(students.get(h).Status.equals("Blocked")){
                                            blocked+=1;
                                        }
                                    }
                                    System.out.println("Number of offered students:-"+company.SelectedStudents.size());
                                    System.out.println("Number of UnOffered students:-"+unOffered);
                                    System.out.println("Number of BLocked students:-"+blocked);
                                }
                                if(f==6){
                                    for(int m = 0;m<students.size();m++){
                                        System.out.println((m+1)+")");
                                        students.get(m).PrintDetails();
                                    }
                                }
                                if(f==7){
                                    for(int m = 0;m<companies.size();m++){
                                        System.out.println((m+1)+")");
                                        companies.get(m).AvailableCompanies();
                                    }
                                }
                                if(f==8){
                                    float total=0;
                                    for(int m = 0;m<students.size();m++){
                                        total+=students.get(m).Salary;
                                    }
                                    float average = total/company.SelectedStudents.size();
                                    System.out.println("Average Package is: "+average);
                                }
                                if(f==9){
                                    companies.get(0).getResults();
                                }
                                if(f==10){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }



    }
}

class Student{

    String Name;
    int RollNo;
    float CGPA;
    String Branch;
    float Salary=0;
    int placed = 0;
    String Status = "UnOffered";
    String getName(){
        return this.Name;
    }
    int getRollNo(){
        return this.RollNo;
    }
    float getCGPA(){
        return this.CGPA;
    }
    String getBranch(){
        return this.Branch;
    }

    public void StudentInfo(String Name, int RollNo, float CGPA, String Branch){
        this.Name = Name;
        this.RollNo = RollNo;
        this.CGPA = CGPA;
        this.Branch = Branch;
    }
    public void PrintDetails(){
        System.out.println("Name: "+this.Name);
        System.out.println("RollNo: "+this.RollNo);
        System.out.println("CGPA: "+this.CGPA);
        System.out.println("Branch: "+this.Branch);
    }
    public boolean IsEligible(Company company){
        if (placed == 0 && CGPA>=company.CG){
            return true;
        }
        if (placed == 1 && CGPA>=company.CG && company.CTC>=3*Salary){
            return true;
        }
        return false;
    }

    public String RegisterCompany(Company company){
        //if CGPA is greater than min CGPA of company
        //if CTC of company is greater than 3* current salary
        //if not placed yet
        //if placed==0 then check just cgpa
        //else check cgpa and ctc
        if (IsEligible(company)){
            return "Applied";
        }
        return "Not-applied";
    }

    public void getCompanies(Company company){
        if(IsEligible(company)){
            company.AvailableCompanies();
        }
        else{
            System.out.println("Unavailable");
        }
    }
    public String getStatus(Company company){
        for(int i = 0;i<company.SelectedStudents.size();i++){
            if(company.SelectedStudents.get(i).Name.equals(this.Name)){   //to be done
                this.Status="Offered";
                return "Offered";
            }
        }

        if(Reject()==1){
            this.Status="Blocked";
            return "Blocked";
        }
        return "UnOffered";
    }
    public void UpdateCGPA(Placement placement, float NewCG){
        this.CGPA = placement.getNewCG(NewCG);
    }
    public int Accept(Company company){
        this.placed = 1;
        this.Salary = company.CTC;
        return 1;
    }
    public int Reject(){
        return 1;
    }



}
class Company{
    String Name;
    String Role;
    float CTC;
    float CG;
    String getName(){
        return this.Name;
    }
    String getRole(){
        return this.Role;
    }
    float getCTC(){
        return this.CTC;
    }
    float getCG(){
        return this.CG;
    }
    public void UpdateRole(String Role){
        this.Role = Role;
    }
    public void UpdatePackage(float CTC){
        this.CTC = CTC;
    }
    public void UpdateCGPA(float CG){
        this.CG = CG;
    }
    public void CompanyInfo(String Name, String Role, float CTC, float CG){
        this.Name = Name;
        this.Role = Role;
        this.CTC = CTC;
        this.CG = CG;
    }
    void AvailableCompanies(){
        System.out.println("CompanyName: "+this.Name);
        System.out.println("Company role offering: "+this.Role);
        System.out.println("Company Package: "+this.CTC+" LPA");
        System.out.println("Company CGPA criteria: "+this.CG);
    }

    ArrayList<Student> SelectedStudents = new ArrayList<Student>();


    public void getSelectedStudents(Student student){
        student.Status = "Offered";
        SelectedStudents.add(student);
    }
    public void getResults(){
        System.out.println(this.Name);
        System.out.println("Following are the students selected-");
        for(int i = 0;i<SelectedStudents.size();i++){
            System.out.println("Name: "+SelectedStudents.get(i).Name);
            System.out.println("RollNo: "+SelectedStudents.get(i).RollNo);
            System.out.println("CGPA: "+SelectedStudents.get(i).CGPA);
            System.out.println("Branch: "+SelectedStudents.get(i).Branch);
        }
    }
    ArrayList<Company> RegisteredCompanies = new ArrayList<Company>();
    void RegisterToInstituteDrive(Company company){
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        System.out.println("Registered!!");
        RegisteredCompanies.add(company);
    }
}


class Placement{
    float NewCG;


    float getNewCG(float NewCG){
        this.NewCG = NewCG;
        return this.NewCG;
    }


    public void OpenCompanyRegistrations(){
        System.out.println("The Institute is open for company registrations for the placements");
        java.util.Date date = new java.util.Date();
        System.out.println(date);
    }
    public void CloseCompanyRegistrations(){
        java.util.Date date = new java.util.Date();
        System.out.println(date);
    }
}