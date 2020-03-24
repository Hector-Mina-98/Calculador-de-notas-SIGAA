package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.*;


public class Panel extends JPanel{
	
	public Panel() {
		
		setLayout(new GridLayout(3, 1));
		
		JPanel lam1 = new JPanel();
		lam1.setLayout(new BorderLayout());
		//lam1.setBackground(SystemColor.window);
		miarea = new JTextArea(7,25);	//(filas, columnas)
		//miarea.setLineWrap(true);		//true para que haga un salto de linea al llegar al borde del area
		JScrollPane laminascroll = new JScrollPane(miarea);		//para que tenga barra de desplazamiento
		lam1.add(laminascroll, BorderLayout.CENTER);
		JButton boton = new JButton("Calcular");
		JButton botonlimpiar = new JButton("Limpiar ");
		botonlimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miarea.setText("");
				Calculator.reset();
			}
		});
		
		boton.addActionListener(new AreaOyente());
		//JPanel lam1sub = new JPanel();
		Box lam1sub = Box.createVerticalBox();
		lam1sub.add(boton);
		lam1sub.add(Box.createVerticalStrut(5));
		lam1sub.add(botonlimpiar);
		lam1.add(lam1sub, BorderLayout.EAST);
		add(lam1);
		
		
		info = new JLabel("");
		respuesta = new JLabel("");
		JScrollPane lam2 = new JScrollPane(info);
		
		//lam2.setLayout(new FlowLayout(FlowLayout.LEFT));
		//lam2.add(info);
		//lam2.getViewport().setBackground(Color.WHITE);		//asi se establece el fondo de un JScrollPane
		add(lam2);
		
		JScrollPane lam3 = new JScrollPane(respuesta);
		//lam3.getViewport().setBackground(Color.WHITE);		//asi se establece el fondo de un JScrollPane
		add(lam3);
		
		////////////////////////////////////////??????????????////////////////////////////////
		
		lam3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getClickCount());
				if (e.getClickCount()==10) {
					System.exit(0);
				}
			}
		});
		
		
		
	}
	
	private class AreaOyente implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			contenido = miarea.getText();
			
			//System.out.println(contenido);
			Calculator.reset();
			Calculator.operar(contenido);
			//System.out.println(Calculator.mostrarInfo());
			infostring = Calculator.mostrarInfo();
			info.setText(infostring);
			//info.setText("23");
			infostring = Calculator.mostrarRespuesta();
			respuesta.setText(infostring);
		}
		
	}
	
	private String contenido;
	private JTextArea miarea;
	private String infostring;
	private JLabel info;
	JLabel respuesta = new JLabel("");
	DecimalFormat df = new DecimalFormat("##.00");

	
}
