import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Gibbler2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Create group
        Scanner in = new Scanner(System.in);
        
        String ans;
        boolean alreadyExists = false;
        
        System.out.println("What do you want to do?\n1. Create Group\n2. Make a Post");
        ans = in.nextLine();
        
        
        if (ans.equals("Create Group")) {
            
            String groupName;
            
            System.out.println("What do you want to name your group?");
            groupName = in.nextLine();
            
            if (!alreadyExists) {
                
                /*Create group table with user.name, user.iD, and add creator to followers*/
                
            }
        }//if (ans.equals("Create Group"))
        
        if (ans.equals("Make a Post")) {
            
            String text;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String postDate;
            
            System.out.println("Type your post!");
            text = in.nextLine();
            text += " ";
            Date date = new Date();
            postDate = dateFormat.format(date);
            
            System.out.println("This is your post: " + text);
            System.out.println("This is the date it was posted: " + postDate);
            
            for (int i = 0; i < (text.length() - 1); i++){
                
                if (text.charAt(i) == '~') {
                    String groupName = text.substring(i, text.indexOf(' '));
                    System.out.println("Your post belongs to this group: " + groupName);
                }
                
                if (text.charAt(i) == '#') {
                    String groupName = text.substring(i, text.indexOf(' '));
                    System.out.println("Your post belongs to this tag: " + groupName);
                }
            }
            
        }
        
        
        
    }
    
}
