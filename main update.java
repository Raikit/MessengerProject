    public void Gibbler2(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Gibbler2 gibbler = new Gibbler2();
        User current = new User();
        //Create group
        Scanner in = new Scanner(System.in);
        
        String ans;
        String sea;
        String sub;
        Search find = new Search();
        Subscribe subs = new Subscribe();
        boolean alreadyExists = false;
        
        //Search through posts and display all public ones.
        Display guest = new Display();
        Display user = new Display();
        
        guest.viewFeed(null);
        
        System.out.println("Welcome to Gibbler! How can we assist you?\n1. Register an Account\n2. Register an Admin Account\n3. Login\n4.Search\n5. View Feed");
        ans = in.nextLine();
        
        if (ans.equals("Register an Account")){
            gibbler.Register();
        }
        
        if (ans.equals("Register an Admin Account")){
            gibbler.RegisterAsAdmin();
        }
        
        if (ans.equals("Login")){
            
            current = gibbler.LogIn();
            user.viewFeed(current.getUN());
            
        }
        
        while ((!ans.equals("Logout")) || (!ans.equals("logout"))){
            
            System.out.println("What section do you want to see?\n1. User Options\n2. Admin Options\n3. Group Options");
            ans = in.nextLine();
            
            if((ans.equals("User Options")) || ((ans.equals("user options")))){
             
                System.out.println("User Options:\n1. Gobble\n2. Edit Profile\n3. Subscribe to a User\n4. Subscribe to a Group\n5. View Feed\n6. Search for User\n7. Search for Group or Tag\n8. Logout");
                ans = in.nextLine();
                
                if ((ans.equals("Gobble")) || (ans.equals("gobble"))) {

                    String text;
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String postDate;
                    String postAdd;
                    boolean postlim = false;
                    System.out.println("Type your gobble!");
                    text = in.nextLine();
                    text += " ";
                    Date date = new Date();
                    postDate = dateFormat.format(date);
                    
                    while (!postlim){
                        if (text.length() > 140){
                            System.out.println("Your gobble is too long! Please keep your gobble under 140 characters.");
                            System.out.println("Type your gobble!");
                            text = in.nextLine();
                            text += " ";
                            postDate = dateFormat.format(date);
                        }
                        else {
                            
                            postlim = true;
                        }
                        
                    }
                    
                    System.out.println("This is your gobble: " + text);
                    System.out.println("This is the date it was posted: " + postDate);

                    for (int i = 0; i < (text.length() - 1); i++){
                        String tempText = text;

                        if (text.charAt(i) == '~') {

                            tempText = text.substring(i);
                            postAdd = text.substring(i, tempText.indexOf(' ') + i);
                            System.out.println("Your gobble belongs to this group: " + postAdd);

                        }

                        if (text.charAt(i) == '#') {

                            tempText = text.substring(i);
                            postAdd = text.substring(i, tempText.indexOf(' ') + i);
                            System.out.println("Your gobble belongs to this tag: " + postAdd);

                        }

                        if (text.charAt(i) == '@'){

                            tempText = text.substring(i);
                            postAdd = text.substring(i, tempText.indexOf(' ') + i);
                            System.out.println("Your gobble will alert this user: " + postAdd);
                        }


                    }//for loop

                }//if (ans.equals("Make a Post"))
                
                if ((ans.equals("Edit Profile")) || (ans.equals("edit profile"))){
                    
                    gibbler.EditProfile(current);
                    
                }
                
                if ((ans.equals("Subscribe to a User")) || (ans.equals("subscribe to a user"))){
                    
                    System.out.println("What is the name of the user you want to subscribe to?");
                    sea = in.nextLine();
                    
                    sub = find.SearchByUser(sea);
                    subs.SubscribeToUser(sub);
                    
                }
                
                if ((ans.equals("Subscribe to a Group")) || (ans.equals("subscribe to a group"))){
                    
                    System.out.println("What is the name of the group you want to subscribe to?");
                    sea = in.nextLine();
                    
                    sub = find.SearchByUser(sea);
                    subs.SubscribeToGroup(sub);
                    
                }
                
                if ((ans.equals("View Feed")) || (ans.equals("view feed"))){
                    
                    user.viewFeed(current.getUN());
                    
                }
                
                if ((ans.equals("Search for a User")) || (ans.equals("search for a user"))){
                    
                    System.out.println("What is the name of the user you want to search for?");
                    sea = in.nextLine();
                    find.SearchByUser(sea);
                }
                
                if ((ans.equals("Search for Group or Tag")) || (ans.equals("search for group or tag"))){
                    
                    System.out.println("What is the tag or group that you want to search for? Please include the & or #");
                    sea = in.nextLine();
                    find.SearchByHash(sea);
                    
                }
                
                if ((ans.equals("Logout")) || (ans.equals("logout"))){

                    System.out.println("Goodbye, Friend");

                }//if (ans.equals("Logout"))
                
            }//if (ans.equals("User Options"))
            
            else if ((ans.equals("Admin Options")) || (ans.equals("admin options"))){
             
                System.out.println("Admin Options:\n1. Delete a User\n2. Delete a Group");
                ans = in.nextLine();
                
                if ((ans.equals("Delete a User")) || (ans.equals("delete a user"))){
                    
                    System.out.println("What is the name of the user you want to delete?");
                    sea = in.nextLine();
                    String del = find.SearchByUser(sea);
                    gibbler.DeleteUser(del);
                    
                    
                }
                
                if ((ans.equals("Delete a Group")) || (ans.equals("delete a group"))){
                    
                    System.out.println("What is the name of the group you want to delete?");
                    sea = in.nextLine();
                    String del = find.SearchByUser(sea);
                    gibbler.DeleteGroup(del);
                    
                }
                
            }//else if (ans.equals("Admin Options"))
            
            else if ((ans.equals("Group Options")) || (ans.equals("group options"))){
             
                System.out.println("Group Options:\n1. Create a Group\n2. Delete a Group");
                ans = in.nextLine();
                
                if ((ans.equals("Create Group")) || (ans.equals("create group"))) {

                    String groupName;

                    System.out.println("What do you want to name your group?");
                    groupName = in.nextLine();

                    if (!alreadyExists) {

                        /*Create group table with user.name, user.iD, and add creator to followers*/

                    }
                }//if (ans.equals("Create Group"))
                
                if ((ans.equals("Delete a Group")) || (ans.equals("delete a group"))){
                    
                    System.out.println("What is the name of the group you want to delete?");
                    sea = in.nextLine();
                    String del = find.SearchByUser(sea);
                    gibbler.DeleteGroup(del);
                    
                }
                
            }//else if (ans.equals("Group Options"))
            
        }//while(ans.equals("Logout"))
        
        
    }//main
