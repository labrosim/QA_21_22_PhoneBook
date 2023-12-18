package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if Sign out presents --> logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwe@d.com", "Ff12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());


        //Assert.assertEquals();
        //Assert.assertNotEquals();
        //Assert.assertTrue();
        //Assert.assertFalse();

    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwe@d.com", "Ff12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());


        //Assert.assertEquals();
        //Assert.assertNotEquals();
        //Assert.assertTrue();
        //Assert.assertFalse();

    }

}
