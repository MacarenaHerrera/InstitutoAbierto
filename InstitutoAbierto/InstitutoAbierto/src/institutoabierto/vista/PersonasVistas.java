/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.vista;

import institutoabierto.modelo.Conexion;
import institutoabierto.modelo.Persona;
import institutoabierto.modelo.PersonaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Maqui's
 */
public class PersonasVistas extends javax.swing.JInternalFrame {
private PersonaData personaData;
private Conexion conexion;
    /**
     * Creates new form AlumnosVistas
     */
    public PersonasVistas() {
    try {
        initComponents();
        
        conexion = new Conexion("jdbc:mysql://localhost/instituto_abierto", "root", "");
        personaData = new PersonaData (conexion);
        
        NumId.setEnabled(false);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PersonasVistas.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NumId = new javax.swing.JTextField();
        TextNombre = new javax.swing.JTextField();
        NumDni = new javax.swing.JTextField();
        NumCelular = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        BotonGuardar = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();
        BotonActualizar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("ALUMNOS");

        jLabel2.setText("Nº REGISTRO ASIGNADO");

        jLabel3.setText("NOMBRE:");

        jLabel4.setText("DNI:");

        jLabel5.setText("CELULAR:");

        NumId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumIdActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonBorrar.setText("Borrar");
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });

        BotonActualizar.setText("Actualizar");
        BotonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarActionPerformed(evt);
            }
        });

        BotonLimpiar.setText("Limpiar");
        BotonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/institutoabierto/vistas/imagenes/icono usuario.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(BotonGuardar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumDni, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NumId, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(NumCelular)
                                .addComponent(TextNombre)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 202, Short.MAX_VALUE)
                .addComponent(BotonBorrar)
                .addGap(43, 43, 43)
                .addComponent(BotonActualizar)
                .addGap(32, 32, 32)
                .addComponent(BotonLimpiar)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NumId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonBorrar)
                    .addComponent(BotonActualizar)
                    .addComponent(BotonLimpiar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //BOTÓN PARA INSCRIBIR A UNA PERSONA
    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        // TODO add your handling code here:
        String nombrePersona=TextNombre.getText();
        int dni=Integer.parseInt(NumDni.getText());
        int celular=Integer.parseInt(NumCelular.getText());
        
        Persona persona = new Persona(nombrePersona, dni, celular);
        
        personaData.inscribirPersona(persona);
        NumId.setText(persona.getId_persona()+"");
        JOptionPane.showMessageDialog(this, "¡¡Alta del usuario exitosa!!");
    }//GEN-LAST:event_BotonGuardarActionPerformed

    //BOTÓN PARA BORRAR A UNA PERSONA
    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed
      int id_persona=Integer.parseInt(NumId.getText());
        personaData.borrarPersona(id_persona);  
        JOptionPane.showMessageDialog(this, "¡¡Usuario borrado!!");
    }//GEN-LAST:event_BotonBorrarActionPerformed

    //BOTÓN PARA ACTUALIZAR A UNA PERSONA
    private void BotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarActionPerformed
        // TODO add your handling code here:
        if(NumId.getText()!=null){
        
        int id_persona=Integer.parseInt(NumId.getText());
        String nombrePersona=TextNombre.getText();
        int dni=Integer.parseInt(NumDni.getText());
        int celular=Integer.parseInt(NumCelular.getText());
                
        Persona persona = new Persona(id_persona, nombrePersona, dni, celular);
        personaData.actualizarPersona(persona);
        JOptionPane.showMessageDialog(this, "¡¡Datos del usuario actualizados!!");
        }
    }//GEN-LAST:event_BotonActualizarActionPerformed

    //BOTÓN PARA LIMPIAR LO INGRESADO
    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
     NumId.setText("");
     TextNombre.setText("");
     NumDni.setText("");
     NumCelular.setText("");
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    //BOTÓN PARA BUSCAR UNA PERSONA CON SU DNI
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
       int dni=Integer.parseInt(NumDni.getText());
        Persona persona = personaData.buscarPersona(dni);
        if (persona!=null){
          NumId.setText(persona.getId_persona()+"");
          TextNombre.setText(persona.getNombrePersona());
          NumCelular.setText(persona.getCelular()+"");
        }else{
          JOptionPane.showMessageDialog(this, "La persona no se encuentra registrada\n Complete los campos para agregar un nuevo usuario");
          }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void NumIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonActualizar;
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JTextField NumCelular;
    private javax.swing.JTextField NumDni;
    private javax.swing.JTextField NumId;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
