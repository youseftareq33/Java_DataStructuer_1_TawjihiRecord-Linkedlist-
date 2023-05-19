package application;

public class Student {
	
	private int seat_num;
	private String branch;
	private double avg;
	
	//////////////////////////////////////////////////////
	public Student(int seat_num,String branch,double avg) {
		this.seat_num=seat_num;
		this.branch=branch;
		this.avg=avg;
	}
	/////////////////////////////////////////////////////
	public int getSeat_num() {
		return seat_num;
	}
	
	public String getBranch() {
		
		String s= branch.substring(0, 1).toUpperCase();
		branch= s+ branch.substring(1); // to make the first letter capital.
		
		return branch;
	}
	
	public double getAvg() {
		return avg;
	}
	/////////////////////////////////////////////////////
	
	
	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	/////////////////////////////////////////////////////
	@Override
	public String toString() {
		return(getSeat_num()+","+getBranch()+","+getAvg());
	}
	
	
	

}
