package utility.overall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;


/* It will provide a method that returns JSONObject of a file kept in a path.
 * using that object you can pass into api .body(jb.toString()) */

public class JSONUtility {
	
	public JSONObject getJSONObject(String path) throws FileNotFoundException {
		File f = new File(path);
		FileReader fr =new FileReader(f);
		JSONTokener jt =new JSONTokener(fr);
		JSONObject jb=new JSONObject(jt);
		
		
		
		return jb;
	}

}
