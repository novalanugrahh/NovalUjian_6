package juaracoding.com.driver.strategies;

import io.cucumber.core.options.Constants;

public class DriverStrategyImplementer {
	
	
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();
			
		case Constants.FIREFOX:
			return new Firefox();

		default:
			return null;
		}
	}

}
