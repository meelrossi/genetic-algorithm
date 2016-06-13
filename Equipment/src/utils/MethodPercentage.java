package utils;

public class MethodPercentage {
	private SelectionMethod method;
	private double percentage;
	
	public MethodPercentage(SelectionMethod method, double percentage) {
		this.method = method;
		this.percentage = percentage;
	}
	
	public SelectionMethod getMethod() {
		return this.method;
	}
	
	public double getPercentage() {
		return this.percentage;
	}
}
