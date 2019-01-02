import java.util.Vector;

import javax.sound.midi.SysexMessage;

public class NumberSelector {

	public static Vector number5 = new Vector();
	public static Vector number46 = new Vector();
	public static Vector number37 = new Vector();
	public static Vector number28 = new Vector();
	
	public static Vector numbers = new Vector();
	

	// 获取 整数 num 的第 i 位的值
	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);// true 表示第i位为1,否则为0
	}
	
	public static boolean count2numbers(int m,int n){
		int count01 = 0;
		int count10 = 0;
		int count00 = 0;
		int count11 = 0;

		
		for(int i=0; i < 10;i++){
			if(!getBit(m, i) && getBit(n, i)){
				count01++;
			}else if(getBit(m, i) && !getBit(n, i)){
				count10++;
			}else if(!getBit(m, i) && !getBit(n, i)){
				count00++;
			}else if(getBit(m, i) && getBit(n, i)){
				count11++;
			}
		}
		if(count01 > 0 && count10>0 && count00>0 && count11>0){
			return true;
		}
		return false;
	}

	// 求解正数的二进制表示法中的 1 的位数
	public static int countBit(int num) {
		int count = 0;
		for (; num > 0; count++) {
			num &= (num - 1);
		}
		return count;
	}
	
	public static void splicedata(){
		for(int i=0;i<4096;i++){
			switch(countBit(i)){
			case 5:
//			case 6:
				number5.add(i);
				break;
			case 4:
			case 6:
				number46.add(i);
				break;
			case 3:
			case 7:
				number37.add(i);
				break;
			case 2:
			case 8:
//			case 2:
//			case 10:
				number28.add(i);
				break;
			default:
				
				break;
			}
		}
	}

	public static void main(String[] args) {
		splicedata();
//		numbers.add(1365);//10101010101
		numbers.add(31); 
//		numbers.add(2016);
		
		int isize = number5.size();
		int i,j;
		for(i = 0;i < isize;i++){
			int itmp = (Integer)number5.elementAt(i);
			for(j = 0;j < numbers.size();j++){
				if(!count2numbers(itmp, (Integer)numbers.elementAt(j))){
					break;
				}
			}
			if(j == numbers.size()){//yes
				numbers.add(itmp);
			}
		}
		
		isize = number46.size();
		for(i = 0;i < isize;i++){
			int itmp = (Integer)number46.elementAt(i);
			for(j = 0;j < numbers.size();j++){
				if(!count2numbers(itmp, (Integer)numbers.elementAt(j))){
					break;
				}
			}
			if(j == numbers.size()){//yes
				numbers.add(itmp);
			}
		}
		
		isize = number37.size();
		for(i = 0;i < isize;i++){
			int itmp = (Integer)number37.elementAt(i);
			for(j = 0;j < numbers.size();j++){
				if(!count2numbers(itmp, (Integer)numbers.elementAt(j))){
					break;
				}
			}
			if(j == numbers.size()){//yes
				numbers.add(itmp);
			}
		}
		
		isize = number28.size();
		for(i = 0;i < isize;i++){
			int itmp = (Integer)number28.elementAt(i);
			for(j = 0;j < numbers.size();j++){
				if(!count2numbers(itmp, (Integer)numbers.elementAt(j))){
					break;
				}
			}
			if(j == numbers.size()){//yes
				numbers.add(itmp);
			}
		}
		

		
		System.out.println("size:"+numbers.size());
		for(i=0;i<numbers.size();i++){
			int itmp = (Integer)numbers.elementAt(i);
//			System.out.println(itmp);
//			System.out.println(Integer.toBinaryString(itmp));
		}
		
	}
}
