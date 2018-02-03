package Foundation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map.Entry;

public class CSVFile {

    private URL _urlToFile;
    private String _separator = "";
    private String _terminator = "";
    private Hashtable<String, String[]> _content = new Hashtable<String, String[]>();

    public CSVFile(URL urlToFile) {
	this._urlToFile = urlToFile;
    }

    public CSVFile(URL urlToFile, String separator, String terminator) {
	this(urlToFile);
	this._separator = separator;
	this._terminator = terminator;
    }

    /**
     * @return the _fileName
     */
    public URL getURL() {
	return _urlToFile;
    }
    
    public void setURL(URL urlToFile) {
	this._urlToFile = urlToFile;
    }

    /**
     * @return the _separator
     */
    public String getSeparator() {
	return _separator;
    }

    /**
     * @param _separator
     *            the _separator to set
     */
    public void setSeparator(String _separator) {
	this._separator = _separator;
    }

    /**
     * @return the _terminator
     */
    public String getTerminator() {
	return _terminator;
    }

    /**
     * @param _terminator
     *            the _terminator to set
     */
    public void setTerminator(String _terminator) {
	this._terminator = _terminator;
    }

    /**
     * @return the _content
     */
    public Hashtable<String, String[]> getContent() {
	return _content;
    }

    /**
     * @param _content
     *            the _content to set
     */
    public void setContent(Hashtable<String, String[]> _content) {
	this._content = _content;
    }

    public static CSVFile of(URL urlToFile, String separator) {

	CSVFile csv;

	csv = new CSVFile(urlToFile);
	csv.setSeparator(separator);

	try (BufferedReader br = new BufferedReader(new FileReader(csv.getURL().getFileURL()))) {
	    for (String line; (line = br.readLine()) != null;) {
		String[] parts = line.split(csv.getSeparator());
		String[] body = Arrays.copyOfRange(parts, 1, parts.length );
		csv.getContent().put(parts[0], body);
	    }
	    // line is not visible here.
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return csv;
    }

    public void save() {
	FileWriter fileWriter = null;
	try {
	    fileWriter = new FileWriter(this.getURL().getFileURL());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	PrintWriter printWriter = new PrintWriter(fileWriter);
	for (Entry<String, String[]> entry : getContent().entrySet()) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(entry.getKey() + getSeparator());
	    int iterations = 0;
	    for (String s : entry.getValue()) {
		iterations++;
		sb.append(s);
		if (!(entry.getValue().length == iterations))
		    sb.append(getSeparator());
		else
		    sb.append("\n");
	    }
	    printWriter.print(sb.toString());
	}
	printWriter.close();
    }

}
