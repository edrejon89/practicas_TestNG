import org.testng.annotations.DataProvider;
public class DataGenerator {

    @DataProvider(name ="register")
    public Object[][] getMailData(){
        return new Object[][]{
                {"prueba@hola.com","Abcd1234"}
        };
    }
}
