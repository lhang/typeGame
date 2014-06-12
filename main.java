
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.OpenOption;

public class main{
	
	String stime = "每个字两秒";
	int mscore = 0;
	JFrame frame = new JFrame("我的游戏");
	JButton start = new JButton("开始");
	JButton end = new JButton("结束");
	JButton pause = new JButton("暂停");
	JButton ok = new JButton("确定");
	JButton restar = new JButton("重新开始");
	JTextField input = new JTextField(10);
	JLabel time = new JLabel();
	JLabel score = new JLabel();
	JLabel type = new JLabel();
	int ISGAMEING = -1;
	startGame oneGame=new startGame(type);
	
	public main(){
		JPanel up = new JPanel();
		up.add(time);
		up.add(score);
		frame.getContentPane().add(up, BorderLayout.NORTH);
		JPanel right = new JPanel();
		BoxLayout boxlayout = new BoxLayout(right ,BoxLayout.Y_AXIS);
		right.setLayout(boxlayout);
		right.add(start);
		right.add(pause);
		right.add(end);
		right.add(restar);
		frame.getContentPane().add(right, BorderLayout.EAST);
		JPanel down = new JPanel();
		down.add(input);
		down.add(ok);
		frame.getContentPane().add(down, BorderLayout.SOUTH);
		JPanel center = new JPanel();
		center.add(type);
		frame.getContentPane().add(center, BorderLayout.CENTER);
		setDefaultWin();
		set_listener();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(center);
	}
	
	public void setDefaultWin(){
		frame.setSize(220, 220);
		time.setText(stime);
		score.setText("等待开始"+mscore);
		type.setText("");
		type.setSize(150, 150);
	}
	
	public void set_listener(){
		Buttonlistener blis = new Buttonlistener();
		start.addActionListener(blis);
		end.addActionListener(blis);
		pause.addActionListener(blis);
		ok.addActionListener(blis);
		restar.addActionListener(blis);
		input.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_ENTER){
					System.out.println("enter");
					gameScore(input.getText(), type.getText());}
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}
	
	class Buttonlistener implements ActionListener{
	    @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
	    	String ID = e.getActionCommand();
	        switch (ID) {
			case "开始":
				if(ISGAMEING==-1)
				{
					oneGame.start();
					score.setText("目前分数："+mscore);
					ISGAMEING = 1;
				}
				break;
			case "暂停":
				oneGame.suspend();
				type.setText("X");
				pause.setText("继续");
				break;
			case "继续":
				pause.setText("暂停");
				oneGame.resume();			
				break;
			case "重新开始":
				mscore = 0;
				break;
			case "确定":
				gameScore(input.getText(), type.getText());
				break;
			case "结束":
				System.exit(0);
				break;
			default:
				break;
			}
	    }
	 }	

	public void gameScore(String a,String b){
		if(a.equals(b)){
			mscore += 10;
			score.setText("目前分数："+mscore);}
		input.setText("");
		System.out.println(a+b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main winMain = new main();
	}

}


