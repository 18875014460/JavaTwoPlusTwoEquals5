package Interview.jiaqi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// Jerry 2015-09-01 18:41PM unused import
/*
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.text.html.HTMLDocument.Iterator;
*/

public class CountWordsMain {

	static FindWordsImp instance;
	
	private static void utilityPrint(String value) {
		System.out.println("ID: " + Thread.currentThread().getId() + " ------:" + value);	
	}
	
	public static void main(String[] args) {
		/* Jerry: unremoved "TODO"
		/TODO Auto-generated method stub*/
		{
			// Jerry why define instance as Static?
			instance = new FindWordsImp();
			utilityPrint("Jerry I am in main thread******************");
			instance.FindAndPrintWords("c:\\temp\\test", 3);
			HashMap<String ,Integer> result=instance.GetResult();
			for (String key : result.keySet()) {  
			    Integer value = result.get(key);  
			    System.out.println( key +": "+value);  
			}   
		}
	}
}
