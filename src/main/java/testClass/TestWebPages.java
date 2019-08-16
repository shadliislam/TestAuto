package testClass;

import supportClass.SignUP;

public class TestWebPages{

    public static void main(String[] args) {
        //String logURl="https://www.facebook.com/";
        String logURl="http://automationpractice.com/index.php";

        SignUP myStoreSignUp=new SignUP(logURl);

        myStoreSignUp.doSignUp();
    }
}
