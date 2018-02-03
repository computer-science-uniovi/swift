package Foundation;

public class URL {
    
    private String _fileURLWithPath = "";
    
    
    public URL(String fileURLWithPath) {
	this._fileURLWithPath = fileURLWithPath;
    }
    
    public String getFileURL() {
	return this._fileURLWithPath;
    }
}
