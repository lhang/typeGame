import java.awt.Color;

import javax.swing.JLabel;


public class startGame extends Thread{
	JLabel type;
	public startGame(JLabel type) {
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		type.setFont(new java.awt.Font("Dialog", 1, 70));    //18代表字号
		type.setBackground(Color.BLUE);  
		while(true){
			char a = getRandomChar();
			type.setText(""+a);
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//在0x4e00---0x9fa5之间产生一个随机的字符
	public static char getRandomChar()
	{		
		//char a = 0x4e00;
		//return a;
		return (char)(0x4e00+(int)(Math.random()*(0xA1A1-0x7E7E+1)));
	}

}
