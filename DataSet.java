package examples.bookTrading;
import java.text.DecimalFormat;

public class DataSet{
	
	public static double[] gety(int op){
		double[] y = new double[4];
		if(op==0){
			y[0]=0;
			y[1]=0;
			y[2]=0;
			y[3]=1;
		}else if(op==1){
			y[0]=0;
			y[1]=1;
			y[2]=1;
			y[3]=1;
		}
		return y;
	}
	public static double[] getx1(){
		double[] x1 = new double[] {0,0,1,1};
		return x1;
	}
	public static double[] getx2(){
		double[] x2 = new double[] {0,1,0,1};
      		return x2;
	}
	
}