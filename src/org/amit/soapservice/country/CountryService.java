/**
 * 
 */
package org.amit.soapservice.country;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.oorsprong.websamples.ArrayOftCountryCodeAndName;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.oorsprong.websamples.TCountryCodeAndName;

/**
 * @author Amit Samanta
 *
 */
public class CountryService {

	/**
	 * @param args : Program takes PIN code as input parameter from command line arguments.
	 */
	public static void main(String[] args) {
		if(args[0]==null) {
			System.out.println("Enter currency code in Command line arguents.");
		}
		else {
			final String currency = args[0].toString();
			CountryInfoService srvc = new CountryInfoService();
			CountryInfoServiceSoapType stub = srvc.getCountryInfoServiceSoap();
			
			System.out.println("Consume Country info service here.. with currency code:"+currency);
			
			ArrayOftCountryCodeAndName country = stub.countriesUsingCurrency(currency.toUpperCase());
			
			List<TCountryCodeAndName> countries = country.getTCountryCodeAndName();
			
			System.out.println("List of country name and SISCode:");
			System.out.println("<--------------...................------------>");
			for( TCountryCodeAndName countrynamecode:countries) {
				System.out.println("Country:"+countrynamecode.getSName()+"  \tSISOCode:"+countrynamecode.getSISOCode());
			}
			
			
			
		}
		

	}
}
