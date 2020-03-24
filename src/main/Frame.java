package main;

import java.awt.*;
import java.net.URL;
import java.util.List;

import javax.swing.*;

public class Frame extends JFrame{
	
	public Frame() {
		
		Toolkit info = Toolkit.getDefaultToolkit();
		Dimension resolucion = info.getScreenSize();
		int alturaPantalla = resolucion.height;
		int anchuraPantalla = resolucion.width;
		
		setSize(anchuraPantalla/3, alturaPantalla*4/5);
		setLocation(anchuraPantalla/3, alturaPantalla/10);
		setTitle("Calculador SIGAA v1.1");
		
		//para poder que se muestre el icono en el jar
		URL ruta = Frame.class.getResource("hand_cursor_icon.png");
		Image icono = info.getImage(ruta);
		setIconImage(icono);
		
		
		setLayout(new BorderLayout());
		
		JPanel lamppl = new JPanel();
		Font fuentetitulo = new Font("Serif", Font.BOLD, 20);
		JLabel titulo = new JLabel("Calculador de Notas SIGAA");
		titulo.setFont(fuentetitulo);
		lamppl.setLayout(new FlowLayout(FlowLayout.LEFT));
		lamppl.setBackground(Color.GRAY.brighter());
		lamppl.add(titulo);
		add(lamppl, BorderLayout.NORTH);
		
		Panel lamina1 = new Panel();
		lamina1.setBackground(SystemColor.window);
		
		add(lamina1, BorderLayout.CENTER);
		
		
	}

}
