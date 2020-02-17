package commandline;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

//	This class is used for the formatting of the test log
public class SpecialFormatter extends Formatter {

	public SpecialFormatter() {
	}

	@Override
	//this is dealing with the formatting of the entries
	public String format(LogRecord record) {
		StringBuffer RecordString = new StringBuffer(1000);
		RecordString.append("<tr>\n");
		
        	RecordString.append("<b>");
            RecordString.append("\t<td>");
            RecordString.append(formatMessage(record));
            RecordString.append("</td>\n");
            RecordString.append("</tr>\n");
		
		return RecordString.toString();
	}
	
	//To format the Date file
	public String formatDate(long miliseconds) {
		SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(miliseconds);
        return date_format.format(resultdate);
	}

	//head of HTML File
    public String getHead(Handler h) {
        return "<!DOCTYPE html>\n<head>\n<style>\n"
            + "table { width: 100% }\n"
            + "th { font:bold 10pt Tahoma; }\n"
            + "td { font:normal 10pt Tahoma; }\n"
            + "h1 {font:normal 11pt Tahoma;}\n"
            + "</style>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h1>" + (new Date()) + "</h1>\n"
            + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
            + "<tr align=\"left\">\n"
            + "\t<th style=\"width:75%\">Log Message</th>\n"
            + "</tr>\n";
      }


    //bottom of HTML File
    public String getTail(Handler h) {
        return "</table>\n</body>\n</html>";
    }

}