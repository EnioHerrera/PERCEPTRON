package examples.bookTrading;
import java.text.DecimalFormat;
import java.util.Random;

public class Perceptron{
	
	public static void main(String[] args) {
		//Test(0,0);
	}
	
	public static void Test(int X1, int X2,int op) {
		double[] W=new double[] {0.9,0.9};
		W=calculation(W,op);
		double res=0;
		for(int j=0; j<2; j++){
			if(j==0)res=res+W[j]*X1;
			if(j==1)res=res+W[j]*X2;
		}
		if(res>0.5){
			res=1;
		}else{
			res=0;
		}
	System.out.print("\n Resultado: "+res+"\n");
		
	}

	public static double [] calculation(double[] W,int op) {
		DataSet DS= new DataSet();
		double[] y= DS.gety(op);
		double[] x1= DS.getx1();
		double[] x2= DS.getx2();
		
		int n=y.length; 
		
		double res=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<2; j++){
				if(j==0)res=res+W[j]*x1[i];
				if(j==1)res=res+W[j]*x2[i];
			}
			if(res>0.5){
				res=1;
			}else{
				res=0;
			}
			if(res!=y[i]){
				getWs(x1,x2,y,W,op);
				break;
			}	
		}
		return W;
	}

	public static void getWs(double[] x1,double[] x2,double[] y, double[] W, int op){
		int size=2;
		int n=y.length;
		double a=0.5;
		double res=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<size; j++){
				if(j==0)res=res+W[j]*x1[i];
				if(j==1)res=res+W[j]*x2[i];
			}
			if(res>0.5){
				res=1;
			}else{
				res=0;
			}
			if(res!=y[i]){
				for(int j=0; j<size; j++){
					W[j]=W[j]+a*(y[i]-res);
				}
			}		
		}	
		calculation(W,op);
	}//end getws

public double Sigmoid(double res){
	double sig=0;
	
	sig= Math.exp(res)/(1+ Math.exp(res));
	if(sig>0.50){
		sig=1;
	}else{
		sig=0;
	}
	return sig;
}//end getws

}


