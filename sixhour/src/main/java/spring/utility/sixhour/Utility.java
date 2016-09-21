package spring.utility.sixhour;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;




public class Utility {
	
	public static String nullCheck(String str) {
		if (str == null) {
			str = "";
		}

		return str;
	}



}
