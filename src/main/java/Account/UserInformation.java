package Account;

public class UserInformation {


    public static void getInfo(Account loggedInAccount){


        System.out.println("Username : " + loggedInAccount.getUsername());
        System.out.println("Name : " + loggedInAccount.getName());
        System.out.println("Surname : " + loggedInAccount.getSurName());
        System.out.println("Phone Number : " + loggedInAccount.getPhoneNumber());
        System.out.println("Identity Number : " + loggedInAccount.getIdentityNumber());
        System.out.println("Birthdate : " + loggedInAccount.getBirthDate());
        System.out.println("Email : " + loggedInAccount.getEmail());



    }





}
