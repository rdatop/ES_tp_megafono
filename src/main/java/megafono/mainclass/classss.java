package megafono.mainclass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class classss {

	public static void main(String[] args) {
		
		Date ahora = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(sdf.format(ahora));
		

	}

}
