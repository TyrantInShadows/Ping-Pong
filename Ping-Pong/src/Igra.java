import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Igra extends JPanel implements KeyListener, ActionListener {

	private int Player1X=10, Player1Y=200,Player2X=720, Player2Y=200, BallX=Player1X+8,BallY=Player1Y+40, BalldirX=4,BalldirY=2, zakasnjenje=10,score1=0,score2=0,maxscore=10;
	private  boolean game=false;
	private Timer timer;
	
	public Igra()
	{
		setFocusable(true);
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(zakasnjenje, this);
		timer.start();
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, 740, 440);
		
		g.setColor(Color.cyan);
		g.fillRect(Player1X, Player1Y, 8, 100);
		g.fillRect(Player2X, Player2Y, 8, 100);
		
		g.setColor(Color.magenta);
		g.fillOval(BallX, BallY, 20, 20);
		
		g.setColor(Color.orange);
		g.setFont(new Font("calibri",Font.PLAIN,20));
		g.drawString("score1: "+score1, 50, 20);
		g.drawString("score2: "+score2, 610, 20);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(game)
		{
			BallX+=BalldirX;
			BallY+=BalldirY;
			if(BallY<=5)
			{
				BalldirY=-BalldirY;
			}
			else if(BallY>420)
			{
				BalldirY=-BalldirY;
			}
			if(new Rectangle(Player1X,Player1Y,8,100).intersects(new Rectangle(BallX,BallY,20,20)))
			{
				BalldirX=-BalldirX;
			}
			else if(new Rectangle(Player2X,Player2Y,8,100).intersects(new Rectangle(BallX,BallY,20,20)))
			{
				BalldirX=-BalldirX;
			}
			if(BallX<5)
			{
				score2++;
				BallX=Player2X-20;
				BallY=Player2Y+40;
				game=false;
			}
			else if(BallX>725)
			{
				score1++;
				BallX=Player1X+8;
				BallY=Player1Y+40;
				game=false;
			}
		}
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			game=true;
		}
		if(!game)
		{
			if(e.getKeyCode()==KeyEvent.VK_W && BallX<350)
			{
				if(Player1Y<10)
				{
					Player1Y=0;
					BallY=Player1Y+40;
				}
				else {
					Player1Y-=10;
					BallY-=10;
				}
			}
			else if(e.getKeyCode()==KeyEvent.VK_S && BallX<350)
			{
				if(Player1Y>=330)
				{
					Player1Y=340;
					BallY=Player1Y+40;
				}
				else {
					Player1Y+=10;
					BallY+=10;
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_UP&& BallX>350)
			{
				if(Player2Y<=10)
				{
					Player2Y=0;
					BallY=Player2Y+50;
				}
				else {
					Player2Y-=10;
					BallY-=20;
				}
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN && BallX>350)
			{
				if(Player2Y>=330)
				{
					Player2Y=340;
					BallY=Player2Y+40;
				}
				else {
					Player2Y+=10;
					BallY+=20;
				}
			}
		}
		else
		{
			if(e.getKeyCode()==KeyEvent.VK_W)
		{
			if(Player1Y<10)
				Player1Y=10;
			else {
				Player1Y-=10;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			if(Player1Y>330)
			Player1Y=340;
			else {
				Player1Y+=10;
			}
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(Player2Y<10)
				Player2Y=10;
			else {
				Player2Y-=10;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(Player2Y>330)
			Player2Y=340;
			else {
				Player2Y+=10;
			}
			}
		}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
