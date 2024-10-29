package CommonJavaTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SettingLogger {
	private static Logger log;
	
	
	public  void settingLogger() {
		log=LogManager.getLogger(this.getClass().getName()); 
		log.info("Logging testCaseStep");
		System.out.println("Practicing logger");
	}
	public static void main(String[] args) {
		SettingLogger settingLogger= new SettingLogger();
		settingLogger.settingLogger();
		
	}

}
