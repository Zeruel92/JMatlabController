import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;


public class Main {

	public static void main(String[] args) throws MatlabConnectionException, MatlabInvocationException {
		MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
				.setHidden(true)
				.setUsePreviouslyControlledSession(true).build();
		//Queste opzioni servono per lanciare delle istanze nascoste di matlab che si
		//autoterminano quando ci si disconnette
		
		MatlabProxyFactory factory = new MatlabProxyFactory(options);
		MatlabProxy proxy = factory.getProxy();
		proxy.setVariable("a", 5);
		proxy.eval("a = a + 6");
		double result = ((double[]) proxy.getVariable("a"))[0];
		System.out.println("Result: " + result);
		proxy.disconnect();
	}

}
