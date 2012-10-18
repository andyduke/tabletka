package by.tabletka.entities;

public class BasicResponse<T> {
	
	private int codeResult;
	private T resulData;
	
	public int getCodeResult() {
		return codeResult;
	}
	public void setCodeResult(int codeResult) {
		this.codeResult = codeResult;
	}
	public T getResulData() {
		return resulData;
	}
	public void setResulData(T resulData) {
		this.resulData = resulData;
	}
	
}
