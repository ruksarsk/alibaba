package pomWithDataProvider;

import org.testng.annotations.DataProvider;

public class PomWithPolicyBazzarDataProvider
{
   @DataProvider(name="policyBazzarData")
   public static String[][] myPolicyData()
   {
	   String Data[][]= {{"7057614152","sonali@1234","Sonali Deshmukh"}};
	   return Data;
   }
}
