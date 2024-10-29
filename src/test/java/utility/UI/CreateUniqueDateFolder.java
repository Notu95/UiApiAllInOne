package utility.UI;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateUniqueDateFolder {
	
	public static void createUniqueDateFolder(String location) {
		String path =System.getProperty("user.dir")+"\\"+location+"\\"+CreateUniqueDateFolder.dateString();
		File folder=new File(path);
		Boolean b=folder.mkdirs();
		if(b=true) {
			System.out.println("folder created at : " + path);
		}else {
			System.out.println("folder not created at : " + path);
		}
		
	}
	public static String dateString() {
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("MMMM dd,yyyy");
		String dateString=currentDateTime.format(format);
		String dateString_1=dateString.replace(" ", "-");
		String dateString_2=dateString_1.replace(",", "-");
		return dateString_2;
		
	}
	public static String getLatestDateFolderName(String dateFolderLocation) {
		File f=new File(System.getProperty("user.dir")+"\\"+dateFolderLocation);
		File[] files=f.listFiles();
		List<String> dateName=Arrays.asList(files).stream().map(file -> file.getName()).map(name -> name.replace("-"," ")).map(name -> ((name.substring(0, name.lastIndexOf(" "))+name.substring(name.lastIndexOf(" "),name.length()).replace(" ", ",") ))).collect(Collectors.toList());
		// dateName.forEach(System.out::println);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd,yyyy");
		Optional<LocalDate> LatestDate=dateName.stream().map(date -> LocalDate.parse(date, formatter)).max(Comparator.naturalOrder());//.orElse("January 01,2000");
		
		String defaultDateString="January 01,2000";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM dd,yyyy");
		LocalDate defaultDate=LocalDate.parse(defaultDateString,formatter1);
		LocalDate LatestDate1=LatestDate.orElse(defaultDate);
		
		
        // Define the input and output date formats
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM dd,yyyy");

        String date = LatestDate1.format(outputFormatter);

        String dateString_1=date.replace(" ", "-");
		String dateString_2=dateString_1.replace(",", "-");
        
		//System.out.println("Latest folder is : "+dateString_2);
		
		return dateString_2;
		
	}
	
	
	public static void main(String arg[]) {
		CreateUniqueDateFolder.createUniqueDateFolder("target\\reports");
		String latestFolder=CreateUniqueDateFolder.getLatestDateFolderName("target\\reports");
		System.out.println("Latest folder is : "+latestFolder);
		
	}
	

}
