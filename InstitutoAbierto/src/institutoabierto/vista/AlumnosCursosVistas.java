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
private MatriculaData matriculaData;
private CursoData cursoData;
private PersonaData personaData;
private ArrayList<Persona> listaPersonas;
private Conexion conexion;
    /**
     * Creates new form AlumnosCursosVistas
     */
    public AlumnosCursosVistas() {
    try {
        initComponents();
        conexion = new Conexion("jdbc:mysql://localhost/instituto_abierto","root","");
        modelo = new DefaultTableModel();
     
     matriculaData=new MatriculaData(conexion);
     listaMatriculas= (ArrayList)matriculaData.listaMatriculas();
     
     cursoData = new CursoData(conexion);
     listaCursos=(ArrayList)cursoData.obtenerCursos();
    
     personaData = new PersonaData (conexion);
     listaPersonas= (ArrayList)personaData.obtenerPersonas();
     
     cargarCursos();
     armarCabeceraTabla();
     cargarDatos();
     
 } catch (ClassNotFoundException ex) {
        Logger.getLogger(AlumnosCursosVistas.class.getName()).log(Level.SEVERE, null, ex);
    }
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

        etiqTitulo.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        etiqTitulo.setForeground(new java.awt.Color(0, 153, 51));
        etiqTitulo.setText("LISTADO DE PERSONAS POR CURSO");
        etiqTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        etiqCurso.setText("CURSO");

        comboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursosActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
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
                .addGap(47, 47, 47)
                .addComponent(etiqTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(etiqTitulo)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqCurso)
                    .addComponent(comboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//AL CLICLEAR EL COMBOBOX ME PERMITE CARGAR DATOS DE CURSOS
    private void comboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursosActionPerformed
              
    }//GEN-LAST:event_comboBoxCursosActionPerformed

    //ME CARGA LOS CURSOS QUE TENGO EN LA LISTA
public void cargarCursos (){
    
    for(Curso item:listaCursos){
        comboBoxCursos.addItem(item);
    }
}

//TITULOS DE LA TABLA
public void armarCabeceraTabla(){
    ArrayList<Object> columna = new ArrayList<>();
    columna.add("ID");
    columna.add("Nombre");
    columna.add("DNI");
    columna.add("Celular");
    for(Object it:columna){
        modelo.addColumn(it);
    }
    tablaPersonas.setModel(modelo);
}

//BORRAR FILAS SEGÚN PARÁMETRO QUE LE DOY
public void borrarFilasTabla(){
    int a=modelo.getRowCount()-1;
    for(int j=a;j>=0;j--){
        modelo.removeRow(j);
    }
}

//AGREGA FILAS EN CADA COLUMNA HASTA CARGAR TODOS LOS CURSOS Y SUS DATOS
public void cargarDatos(){
    
    borrarFilasTabla();
    
    Curso curso= (Curso)comboBoxCursos.getSelectedItem();
    
    for(Matricula mat:listaMatriculas){
        
        if(mat.getCurso().getId_curso()==curso.getId_curso()){
            
            modelo.addRow(new Object[]{mat.getPersona().getId_persona(),mat.getPersona().getNombrePersona(),mat.getPersona().getDni(),mat.getPersona().getCelular()});
        }
        
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Curso> comboBoxCursos;
    private javax.swing.JLabel etiqCurso;
    private javax.swing.JLabel etiqTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables
}