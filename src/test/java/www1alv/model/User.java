package www1alv.model;

public class User {
    private static String userName;
    private static String userLastName;
    private static String email;
    private static String phoneNumber;
    private static String[] checkoutUserData;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        User.userName = userName;
    }

    public static String getUserLastname() {
        return userLastName;
    }

    public static void setUserLastname(String userLastname) {
        userLastName = userLastname;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }


    public static void setPhoneNumber(String phoneNumber) {
        User.phoneNumber = phoneNumber;
    }

    public static String[] getCheckoutUserData() {
        return checkoutUserData;
    }

    public static void setCheckoutUserData(String[] checkoutUserData) {
        User.checkoutUserData = checkoutUserData;
    }
}
