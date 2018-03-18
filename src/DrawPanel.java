/*
 資管三A 劉昌平
 103403519
 */

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;

public class DrawPanel extends JPanel{
	private int pointcount = 0;
	private Point points[] = new Point[10000];
	
	DrawPanel(){
		setBackground(Color.WHITE);
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	private class MouseMotionHandler extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e){
			if(pointcount < points.length){
				points[pointcount] = e.getPoint();
				pointcount++;
				repaint();
			}
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0; i<pointcount; i++)
			g.fillOval(points[i].x, points[i].y, 4, 4);
	}
}

