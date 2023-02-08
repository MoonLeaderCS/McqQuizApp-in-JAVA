import java.util.*;
import java.io.*;

class McqQuizApp 
{
    public static Scanner sc = new Scanner(System.in);
    public static int notReady=1;
    public static char start;
    public static void main(String[] args) 
    {

        System.out.print("Press 1 to Start the Quiz or Press 0 to Exit: ");
        int ready = sc.nextInt();
        System.out.println();
        if (ready == 1) {
            startQuiz();
        } else if(ready == 0) {
            notReady=0;
            System.out.println("Quiz has been Closed Successfully!!!");
        } else {
            notReady=0;
        }
        do {
            if(notReady==0) {
                System.out.println("Error...Please Enter Valid Key!!!");
                break;
            }
            System.out.println("\nPress 1 to Restart or Press 0 to Exit: ");
            ready = sc.nextInt();
            if (ready==1 && notReady==1) {
                startQuiz();
            } else if(ready==0) {
                System.out.println("Quiz has been Closed Successfully!!!");
                break;
            } else {
                System.out.println("Error...Please Enter Valid Key!!!");
            }
        }while(start=='y' && notReady==1);
    }

    public static void startQuiz() 
    {
        ArrayList<String> queList = new ArrayList<String>(
                Arrays.asList(
                        "Que1. Which of the following option leads to the portability and security of Java?",
                        "Que2. Which of the following is not a Java features?",
                        "Que3. The \\u0021 article referred to as a?",
                        "Que4. _____ is used to find and fix bugs in the Java programs?",
                        "Que5. Which of the following is a valid long literal?",
                        "Que6. What is the return type of the hashCode() method in the Object class?",
                        "Que7. What does the expression float a = 35/0; return?",
                        "Que8. Evaluate the following Java expression, if x=3, y=5, and z=10:\n      ++z + y - y + z + x++",
                        "Que9. Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?",
                        "Que10. In which process, a local variable has the same name as one of the instance variables?"));

        ArrayList<String> optList = new ArrayList<>(Arrays.asList(
                "A) Bytecode is executed by JVM\nB) The applet makes the Java code secure and portable\nC) Use of exception handling\nD) Dynamic binding between objects",
                "A) Dynamic\nB) Architecture Neutral\nC) Use of pointers\nD) Object-oriented",
                "A) Unicode escape sequeListnce\nB) Octal escape\nC) Hexadecimal\nD) Line feed",
                "A) JVM\nB) JRE\nC) JDK\nD) JDB",
                "A) ABH8097\nB) L990023\nC) 904423\nD) 0xnf029L",
                "A) Object\nB) int\nC) long\nD) void",
                "A) 0\nB) Not a Number\nC) Infinity\nD) Run time exception",
                "A) 24\nB) 23\nC) 20\nD) 25",
                "A) javap tool\nB) javaw command\nC) Javadoc tool\nD) javah command",
                "A) Serialization\nB) Variable Shadowing\nC) Abstraction\nD) Multi-threading"));

        ArrayList<Character> ansList = new ArrayList<>(Arrays.asList('A', 'C', 'A', 'D', 'D', 'B', 'C', 'D', 'C', 'B'));

        int totalMarks = 0;
        System.out.print("Enter Your Name: ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("Enter Your Enrollment Number: ");
        String enroll = sc.next();
        System.out.print("Are you ready for Quiz? (y/n): ");
        start = sc.next().charAt(0);
        start=Character.toLowerCase(start);
        System.out.println();
        if (start == 'y') 
        {
            System.out.print("This Quiz has 10 MCQ only.\n\n");
            for (int i = 0; i < queList.size(); i++) 
            {
                System.out.println(queList.get(i));
                System.out.println(optList.get(i));
                System.out.print("Choose Correct Option: ");
                char chooseOpt = sc.next().charAt(0);
                chooseOpt=Character.toUpperCase(chooseOpt);
                System.out.println();
                if (chooseOpt == ansList.get(i))
                    totalMarks++;
            }

            System.out.println("This is Your Result:");
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------");
            System.out.println("Name                         " + "Enrollment                         "
                    + "Marks                         " + "Percentage");
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------");

            int gap1 = 4 + 25;
            int gap2 = 10 + 25;
            int gap3 = 5 + 25;
            System.out.print(name);

            for (int k = 0; k<gap1 - name.length(); k++)
                System.out.print(" ");
            System.out.print(enroll);

            for (int k = 0; k<gap2 - enroll.length(); k++)
                System.out.print(" ");
            System.out.print(totalMarks + " out of " + queList.size());

            String t = String.valueOf((totalMarks + " out of " + queList.size()));

            for (int k = 0; k<gap3 - t.length(); k++)
                System.out.print(" ");

            float totalqueList = queList.size();
            System.out.format("%.2f", (totalMarks / totalqueList) * 100);
            System.out.println("%");
            System.out.println("\n\nSuccessfully attempted this Quiz!!!");
            System.out.println();
        } 
        else {
            notReady=0;
            System.out.println("Quiz has been Closed Successfully!!!");
        }
    }
}