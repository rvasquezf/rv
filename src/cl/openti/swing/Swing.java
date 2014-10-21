package cl.openti.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial") //Sugerencia del IDE
public class Swing extends JFrame implements ActionListener {


	public Swing (String s)
	{
		//Frame Principal
		this.setTitle(s);
		//this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null); //arrancar al centro de la pantalla
		this.setLayout(null);
		this.setBounds(10, 10, 540, 540);
		
		
		//Panel interno del frame
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(5, 5, 520, 520);
		panel.setBackground(Color.gray);
		
		//Boton Mostrar
		JButton bg = new JButton("Mostrar");
		bg.addActionListener(this);
		bg.setBounds(280, 450, 100, 30);
		
		//Boton Cerrar
		JButton bc = new JButton("Cerrar");
		bc.setBounds(400, 450, 100, 30);
		
		//label boton traspasar
		
		JLabel jlbltraspasar = new JLabel("Traspasar");
		jlbltraspasar.setBounds(195, 130, 500, 200);
		
		
		//Boton Traspasar
		JButton bt = new JButton(">>");
		bt.setBounds(200, 250, 60, 30);
		
		
		//label Con mensaje de mostrar
		JLabel jlblMensajes = new JLabel();
		jlblMensajes.setBounds(30, 300, 500, 200);
		
		
		//Lista usuarios equipo a
		JList<String> l1 = new JList<String>();
		l1.setBounds(20, 200, 150, 150);
		l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // para seleccionar solo un elemento de la lista
		l1.setModel(modeloDelJList);
		
		
		//Lista Usuario equipo b
		JList<String> l2 = new JList<String>();
		l2.setBounds(290, 200, 150, 150);
		l2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		l2.setModel(modeloDelJlist2);
		
		//Agregando componentes a la ventana
		panel.add(bg);
		panel.add(bc);
		panel.add(l1);
		panel.add(l2);
		panel.add(jlblMensajes);
		panel.add(bt);
		panel.add(jlbltraspasar);
		this.add(panel);
		this.setVisible(true);
		
		
		/*
		 * Boton Cerrar al boton se le agrega el actionlistener y se genera la estructura,
		 * y en ese se inventa el nombre de la accion.
		 */
		bc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clickBotonCerrar(e);
			}
			
			/*
			 * Dentro de la misma accion creada, se hace el evento,
			 * con showconfirmdialog, se genera una ventana emergente
			 * con condicionante de si o no. este elemento trabaja con enteros
			 * y al seleccionar la opcion del joptionpane, se crea un if
			 * para validar dicha seleccion.
			 */

			private void clickBotonCerrar(ActionEvent e) {
				
				int respuesta = JOptionPane.showConfirmDialog(null,"¿Seguro que desea salir ?", "Salir", JOptionPane.YES_NO_OPTION);
	            if (respuesta == JOptionPane.YES_OPTION)
	            {
	                System.exit(0);
	            }
			}
		});//Fin del boton Cerrar
		
		
		/*
		 * Boton Guardar
		 */
		bg.addActionListener(new ActionListener() { // a la variable boton le agrego actionlistener y creo uno nuevo
			
			/*
			 * Este codigo se genera al darle un new ActionListener() y el tab
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * y le doy el nombre que quiero que tenga la accion.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				clickBotonMostrar(e);
				
			}
			
			/*
			 * ahora creo una funcion con el nombre que le di al actionperformed
			 * y aqui es donde doy la configuracion del boton.
			 */
			
			private void clickBotonMostrar(ActionEvent e)
			{
				
				if(lista.isEmpty())
				{
					l1.setModel(modeloDelJList);
					cargarLista();
					mostrarLista();
					jlblMensajes.setText("Datos Mostrados");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ya estan LISTOS!!");
					jlblMensajes.setText("Está Ingresando datos duplicados");
				}
				//JOptionPane.showMessageDialog(null, "OK");
				
			}
		});
		
		/*
		 * Boton traspasar
		 */
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickBotonTraspasar(e);
				
			}
			
			private void clickBotonTraspasar(ActionEvent e)
			{
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No existen datos");
					jlblMensajes.setText("Debe tener datos en la lista principal");
				}
				
				if(!lista.isEmpty())
				{
				String nombre;
				nombre = (String) l1.getSelectedValue();
				modeloDelJlist2.addElement(nombre);
				modeloDelJList.removeElement(l1.getSelectedValue());
				jlblMensajes.setText("Datos Traspasados!");
				}
			}
		});
		

	}


	
	/*
	 * Se define un modelo a la lista para poder hacerla moldeable y con esto
	 * agregar o eliminar elementos con metodos.
	 */
	
	//Lista a
	static DefaultListModel<String> modeloDelJList = new DefaultListModel();
	
	//Lista b
	
	static DefaultListModel<String> modeloDelJlist2 = new DefaultListModel();
	/*
	 * Listas
	 */
	
	List<Usuario> lista = new ArrayList<Usuario>(); //se crea un arraylist llamado lista
	List<Usuario> lista2 = new ArrayList<Usuario>();
	
	
	/*
	 * metodo cargar Lista
	 */
	public void cargarLista()
	{
			lista.add(new Usuario("ricardo"));
			lista.add(new Usuario("marisol"));
			lista.add(new Usuario("carol"));
			lista.add(new Usuario("gerardo"));
			lista.add(new Usuario("alejandro"));
	}
	
	
	/*
	 * metodo mostrar la lista
	 */
	public void mostrarLista()
	{
		Iterator<Usuario> it = lista.iterator();
		
		while (it.hasNext()) {
			Usuario usuario =  it.next();
			modeloDelJList.addElement(usuario.nombre);
			//System.out.printf("%s \n", usuario.nombre);
		}
	}
	
	
	/*
	 * MAIN
	 */
	
	
	public static void main(String[] args) {
		
		Swing miframe = new Swing("Swing");
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

/*
 * Clase USUARIO
 */

	class Usuario {
	
	
		String nombre;
		
	
			public Usuario(String nombre) {
				super();
				this.nombre = nombre;
		}
	
	
			public String getNombre() {
				return nombre;
		}
	
	
			public void setNombre(String nombre) {
				this.nombre = nombre;
		}
	
	

}






