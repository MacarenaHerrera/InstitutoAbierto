/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.vista;

import institutoabierto.modelo.Conexion;
import institutoabierto.modelo.Curso;
import institutoabierto.modelo.CursoData;
import institutoabierto.modelo.Persona;
import institutoabierto.modelo.PersonaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Maqui's
 */
public class CursoVistas extends javax.swing.JInternalFrame {
 private Conexion conexion;
 private CursoData cursodata;
 private PersonaData personadata;
    /**
     * Creates new form CursoVistas
     */
    public CursoVistas() {
      initComponents(); 
      
      try {
         
         conexion = new Conexion("jdbc:mysql://localhost/instituto_abierto", "root", "");
         cursodata = new CursoData(conexion);
         personadata = new PersonaData(conexion);
         
         texidcurso.setEnabled(false);
                  
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(CursoVistas.class.getName()).log(Level.SEVERE, null, ex);
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

        jTextField4 = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        texNombre = new javax.swing.JTextField();
        texCosto = new javax.swing.JTextField();
        texCupoMax = new javax.swing.JTextField();
        txDniResponsable = new javax.swing.JTextField();
        btguardarcurso = new javax.swing.JButton();
        texidcurso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtBuscar = new javax.swing.JButton();
        BtBorrar = new javax.swing.JButton();
        btactualizar = new javax.swing.JButton();
        BtLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTextField4.setText("jTextField4");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setText("GESTIÓN CURSOS");

        texNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texNombreActionPerformed(evt);
            }
        });

        texCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texCostoActionPerformed(evt);
            }
        });

        btguardarcurso.setText("Guardar");
        btguardarcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarcursoActionPerformed(evt);
            }
        });

        texidcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texidcursoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("NOMBRE CURSO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("DESCRIPCIÓN");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText(" COSTO");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("CUPO MÁXIMO");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("DNI RESPONSABLE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("ID ASIGNADO DE CURSO");

        BtBuscar.setText("Buscar");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });

        BtBorrar.setText("Borrar");
        BtBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBorrarActionPerformed(evt);
            }
        });

        btactualizar.setText("Actualizar");
        btactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btactualizarActionPerformed(evt);
            }
        });

        BtLimpiar.setText("Limpiar");
        BtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLimpiarActionPerformed(evt);
            }
        });

        texDescripcion.setColumns(20);
        texDescripcion.setRows(5);
        jScrollPane1.setViewportView(texDescripcion);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Debe estar registrado en el instituto  ");

        jLabel9.setText("$");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Ingresar nombre si desea buscar curso ya existente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(texidcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btguardarcurso)
                                    .addGap(29, 29, 29)
                                    .addComponent(BtBorrar)
                                    .addGap(29, 29, 29)
                                    .addComponent(btactualizar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtLimpiar))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(54, 54, 54)
                                                .addComponent(jLabel9))
                                            .addComponent(jLabel6))
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(texCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txDniResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel8))
                                        .addComponent(texCupoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addComponent(jLabel10)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(texNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(texCupoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txDniResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(texidcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btguardarcurso)
                    .addComponent(BtBorrar)
                    .addComponent(btactualizar)
                    .addComponent(BtLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texNombreActionPerformed
//OPCION PARA GUARDAR UN CURSO
    private void btguardarcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarcursoActionPerformed
        // TODO add your handling code here:
        
                
        String nombreCurso = texNombre.getText();
        String descripcion = texDescripcion.getText();
        double costo = Double.parseDouble(texCosto.getText());
        int cupoMax = Integer.parseInt(texCupoMax.getText());
        Persona persona = personadata.buscarPersona(Integer.parseInt(txDniResponsable.getText()));
        System.out.println(persona);
        
        Curso curso = new Curso (nombreCurso, descripcion, costo, cupoMax, persona);
        cursodata.resgitrarCurso(curso);
        texidcurso.setText(curso.getId_curso()+"");
        JOptionPane.showMessageDialog(this, "¡¡Alta de Curso exitosa!!");
         
    }//GEN-LAST:event_btguardarcursoActionPerformed
    
    private void texCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texCostoActionPerformed

    private void texidcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texidcursoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_texidcursoActionPerformed
//OPCIÓN PARA GUARDAR UN CURSO
    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
      String nombreCurso=(texNombre.getText());
        Curso curso = cursodata.buscarCurso(nombreCurso);
        if (curso!=null){
          texNombre.setText(curso.getNombreCurso());
          texDescripcion.setText(curso.getDescripcion());
          texCosto.setText(curso.getCosto()+""); 
          texCupoMax.setText(curso.getCupoMax()+"");
          txDniResponsable.setText(curso.getPersona().getDni()+"");
          texidcurso.setText(curso.getId_curso()+"");
        }else{
          JOptionPane.showMessageDialog(this, "El Curso no se encuentra cargado\n Complete los campos para agregar uno nuevo");
// TODO add your handling code here:
        }
    }//GEN-LAST:event_BtBuscarActionPerformed
   //OPCIÓN PARA BORRAR UN CURSO
    private void BtBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBorrarActionPerformed
       int id_curso=Integer.parseInt(texidcurso.getText());
       cursodata.borrarCurso(id_curso);   // TODO add your handling code here:
       JOptionPane.showMessageDialog(this, "¡¡Curso borrado!!");
    }//GEN-LAST:event_BtBorrarActionPerformed
//OPCIÓN PARA ACTUALIZAR UN CURSO (ID PERSONA PONE -1)
    private void btactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btactualizarActionPerformed
        // TODO add your handling code here:
        if(texidcurso.getText()!=null){
        
        int id_curso=Integer.parseInt(texidcurso.getText());
        String nombreCurso = texNombre.getText();
        String descripcion = texDescripcion.getText();
        double costo = Double.parseDouble(texCosto.getText());
        int cupoMax = Integer.parseInt(texCupoMax.getText());
        
        //Persona persona = new Persona();
        //persona.getId_persona();
       //personadata.buscarPersonaxId(persona.getId_persona());
          
        Curso curso = new Curso(id_curso, nombreCurso, descripcion, costo, cupoMax);
        cursodata.actualizarCurso(curso);
        JOptionPane.showMessageDialog(this, "¡¡Datos del Curso actualizado!!");
        }
    }//GEN-LAST:event_btactualizarActionPerformed
//OPCION PARA BORRAR TODOS LOS CAMPOS DEL FORMULARIO
    private void BtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimpiarActionPerformed
     texCosto.setText("");
     texCupoMax.setText("");
     texDescripcion.setText("");
     texNombre.setText(""); 
     txDniResponsable.setText("");
     texidcurso.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_BtLimpiarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBorrar;
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtLimpiar;
    private javax.swing.JButton btactualizar;
    private javax.swing.JButton btguardarcurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField texCosto;
    private javax.swing.JTextField texCupoMax;
    private javax.swing.JTextArea texDescripcion;
    private javax.swing.JTextField texNombre;
    private javax.swing.JTextField texidcurso;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txDniResponsable;
    // End of variables declaration//GEN-END:variables
}
