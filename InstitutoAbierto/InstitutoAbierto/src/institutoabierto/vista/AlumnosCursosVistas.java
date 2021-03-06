/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.vista;

import institutoabierto.modelo.Conexion;
import institutoabierto.modelo.Curso;
import institutoabierto.modelo.CursoData;
import institutoabierto.modelo.Matricula;
import institutoabierto.modelo.MatriculaData;
import institutoabierto.modelo.Persona;
import institutoabierto.modelo.PersonaData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maqui's
 */
public class AlumnosCursosVistas extends javax.swing.JInternalFrame {
private DefaultTableModel modelo;
private ArrayList<Matricula> listaMatriculas;
private ArrayList<Curso> listaCursos;
private MatriculaData matriculadata;
private CursoData cursoData;
private PersonaData personadata;
private ArrayList<Persona> listaPersonas;
private Conexion conexion;
    /**
     * Creates new form AlumnosCursosVistas
     */
    public AlumnosCursosVistas() {
    initComponents();
        try {
               
        conexion = new Conexion("jdbc:mysql://localhost/instituto_abierto","root","");
        modelo = new DefaultTableModel();
     
     matriculadata=new MatriculaData(conexion);
     listaMatriculas = (ArrayList)matriculadata.listaMatriculas();
     
     cursoData = new CursoData(conexion);
     listaCursos=(ArrayList)cursoData.listaCursos();
    
     personadata = new PersonaData (conexion);
     listaPersonas= (ArrayList)personadata.listaPersonas();
     
     cargarCursos();
     armarCabeceraTabla();
     cargarDatos();
     
 } catch (ClassNotFoundException ex) {
        Logger.getLogger(AlumnosCursosVistas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    //TITULOS DE LA TABLA
public void armarCabeceraTabla(){
     ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("FECHA");
        columnas.add("COSTO");
        //columnas.add("CURSO");
        columnas.add("PERSONA");
        for(Object it:columnas){
        
            modelo.addColumn(it);
        }
        tablaPersonas.setModel(modelo);
        
}
//BORRAR FILAS SEGÚN PARÁMETRO QUE LE DOY
public void borrarFilasTabla(){
    int a=modelo.getRowCount()-1;
    System.out.println("Tabla" + a);
    for(int i=a;i>=0;i--){
        modelo.removeRow(i);
        System.out.println("Tabla" + i);
    }
}

//AGREGA FILAS EN CADA COLUMNA HASTA CARGAR TODOS LOS CURSOS Y SUS DATOS
public void cargarDatos(){
    
    //borrarFilasTabla();
    //modelo.setColumnCount(0);
    //armarCabeceraTabla();
    
    //obtengo curso del CB
    
    MatriculaData md=new MatriculaData(conexion);
             Curso seleccionado=(Curso)comboBoxCursos.getSelectedItem();
           listaMatriculas=(ArrayList) md.obtenerMatriculaxCurso(seleccionado.getId_curso());
        //Llenar filas
        for(Matricula m:listaMatriculas){
        
            //Comparo por los id o sobreescribo el método equals en Materias
           // if(m.getMateria().getId()==mat.getId()){
            
            modelo.addRow(new Object[]{m.getId_matricula(),m.getFecha(),m.getCosto(),m.getPersona().getNombrePersona()});
            }  
    
    
    
    
    //urso mat= (Curso)comboBoxCursos.getSelectedItem();
    
    //Llenar filas
    //for(Matricula m:listaMatriculas){
        
        //if(m.getCurso().getId_curso()==mat.getId_curso()){
            
           // modelo.addRow(new Object[]{m.getPersona().getId_persona(),m.getPersona().getNombrePersona(),m.getPersona().getDni(),m.getPersona().getCelular()});
       // }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqTitulo = new javax.swing.JLabel();
        etiqCurso = new javax.swing.JLabel();
        comboBoxCursos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        etiqTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiqTitulo.setForeground(new java.awt.Color(0, 153, 51));
        etiqTitulo.setText("LISTADO DE PERSONAS POR CURSO");
        etiqTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        etiqCurso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiqCurso.setForeground(new java.awt.Color(0, 0, 153));
        etiqCurso.setText("CURSO");

        comboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursosActionPerformed(evt);
            }
        });

        tablaPersonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPersonas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etiqCurso)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(etiqTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(etiqTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqCurso)
                    .addComponent(comboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//AL CLICLEAR EL COMBOBOX ME PERMITE CARGAR DATOS DE CURSOS
    private void comboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursosActionPerformed
        borrarFilasTabla();      
        cargarDatos();
    }//GEN-LAST:event_comboBoxCursosActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Curso> comboBoxCursos;
    private javax.swing.JLabel etiqCurso;
    private javax.swing.JLabel etiqTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables

//ME CARGA LOS CURSOS QUE TENGO EN LA LISTA
public void cargarCursos (){
    
    for(Curso item:listaCursos){
        comboBoxCursos.addItem(item);
    }
}
}
