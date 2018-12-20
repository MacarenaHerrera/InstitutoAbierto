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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maqui's
 */
public class MatriculaVistas extends javax.swing.JInternalFrame {
//private DefaultTableModel modelo;
//private ArrayList<Matricula> listaMatriculas;
//private ArrayList<Curso> listaCursos;

private CursoData cursodata;
private PersonaData personadata;
//private ArrayList<Persona> listaPersonas;
private Conexion conexion;
private MatriculaData matriculadata;

private Curso curso;
    /**
     * Creates new form MatriculaVistas
     */
    public MatriculaVistas() {
    try {
        initComponents();
        conexion = new Conexion("jdbc:mysql://localhost/instituto_abierto","root","");
        //modelo = new DefaultTableModel();
        
        matriculadata=new MatriculaData(conexion);
        //listaMatriculas= (ArrayList)matriculadata.listaMatriculas();
        
        cursodata = new CursoData(conexion);
        //listaCursos=(ArrayList)cursodata.listaCursos();
        
        personadata = new PersonaData (conexion);
        //listaPersonas= (ArrayList)personadata.listaPersonas();
        
      // Txcosto.setEnabled(false);
      TxFecha.setText(FechaActual());
        TxIdMat.setEnabled(false);
        TxFecha.setEnabled(false);
//        cargarCursos();
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MatriculaVistas.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxIdMat = new javax.swing.JTextField();
        TxDni = new javax.swing.JTextField();
        Btguardar = new javax.swing.JButton();
        BtBorrar = new javax.swing.JButton();
        Btlimpar = new javax.swing.JButton();
        TxFecha = new javax.swing.JTextField();
        TxCurso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel7.setText("Debe estar registrado en el instituto");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MATRICULA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nº MATRICULA ASIGNADO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("FECHA INSCRIPCIÓN");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("DNI ALUMNO");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("NOMBRE CURSO");

        Btguardar.setText("Guardar");
        Btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtguardarActionPerformed(evt);
            }
        });

        BtBorrar.setText("Anular matrícula");
        BtBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBorrarActionPerformed(evt);
            }
        });

        Btlimpar.setText("Limpiar");
        Btlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtlimparActionPerformed(evt);
            }
        });

        TxFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxFechaActionPerformed(evt);
            }
        });

        TxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxCursoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Debe estar inscripto en el Instituto");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Debe ser un curso válido del Instituto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TxIdMat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TxCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtBorrar)
                .addGap(18, 18, 18)
                .addComponent(Btlimpar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxIdMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btguardar)
                    .addComponent(BtBorrar)
                    .addComponent(Btlimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static String FechaActual(){
    Date fecha = new Date();
    SimpleDateFormat Formatofecha = new SimpleDateFormat("dd/MM/yyyy");
    return Formatofecha.format(fecha);
}
    
    private void BtBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBorrarActionPerformed
         //TODO add your handling code here:
       int id_matricula=Integer.parseInt(TxIdMat.getText());
       matriculadata.borrarMatricula(id_matricula);
       JOptionPane.showMessageDialog(this, "¡¡Matricula anulada exitosamente!!");
    }//GEN-LAST:event_BtBorrarActionPerformed

    private void BtguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtguardarActionPerformed
        // TODO add your handling code here:
        //int id_matricula=Integer.parseInt(TxIdMat.getText());
        
        
        LocalDate fecha=LocalDate.parse(TxFecha.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(fecha);
        
        //double costo=Double.parseDouble(Txcosto.getText());
       //Curso curso= cursodata.buscarCursoxId(id_curso);
        //curso.getCosto();
        //  double costo=curso.getCosto();
        //double costo=Double.parseDouble(Txcosto.getText());
        //double costo= cursodata.
        
        //Curso curso= cursodata.buscarCurso(nombreCurso);
        //double costo= Double.parseDouble(Txcosto.getText());
         
               
        int dni=Integer.parseInt(TxDni.getText());
        Persona persona = personadata.buscarPersona(dni);
        persona.getId_persona();
        System.out.println(persona.getNombrePersona());
        
        String nombreCurso=TxCurso.getText();
        Curso curso= cursodata.buscarCurso(nombreCurso);
        curso.getId_curso();
        double costo= curso.getCosto(); 
        
        System.out.println(curso.getNombreCurso());
        
        Matricula matricula=new Matricula (fecha, costo, persona, curso);
        
         
        matriculadata.registrarMatricula(matricula);
       TxIdMat.setText(matricula.getId_matricula()+"");
       JOptionPane.showMessageDialog(this, "¡¡Inscripción exitosa!!");
    }//GEN-LAST:event_BtguardarActionPerformed

    /*    */
    private void TxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxCursoActionPerformed

    private void BtlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtlimparActionPerformed
        // TODO add your handling code here:
        //TxCosto.setText("");
        TxCurso.setText("");
        TxDni.setText("");
        
        TxIdMat.setText("");
    }//GEN-LAST:event_BtlimparActionPerformed

    private void TxFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxFechaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TxFechaActionPerformed
/*  
 //ME CARGA LOS CURSOS QUE TENGO EN LA LISTA
/*public void cargarCursos (){
    
    for(Curso item:listaCursos){
        JcbListaCursos.addItem(item);
    }

}
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBorrar;
    private javax.swing.JButton Btguardar;
    private javax.swing.JButton Btlimpar;
    private javax.swing.JTextField TxCurso;
    private javax.swing.JTextField TxDni;
    private javax.swing.JTextField TxFecha;
    private javax.swing.JTextField TxIdMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

}