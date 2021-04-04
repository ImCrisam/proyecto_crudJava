/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelos.Maquinas_Mantenimiento;
import controlador.ConMantenimientos;
import controlador.ConMaquinasMantenimiento;
import controlador.ConMaquinas;
import controlador.ConTrabajadores;
import java.util.ArrayList;

import modelos.Mantenimiento;
import modelos.Maquina;

import modelos.Trabajador;

/**
 *
 */
public class MaquinasMantenimientoForm extends javax.swing.JFrame {

    /**
     * Creates new form MaquinasMantenimientoForm
     */
    ConMaquinasMantenimiento controlador;
    ArrayList<Mantenimiento> arrayMantenimientos;
    ArrayList<Maquina> arrayMaquinas;
    ArrayList<Trabajador> arrayTrabajadores;
    boolean isNew;

    public MaquinasMantenimientoForm(Maquinas_Mantenimiento modelo, boolean isNew) {
        initComponents();
        controlador = new ConMaquinasMantenimiento();
        llenarComboBoxs();
        txtMantenimientos.setEditable(false);
        txtMaquinas.setEditable(false);
        txtTrabajadores.setEditable(false);

        this.isNew = isNew;
        if (isNew) {
            txtId.setEnabled(false);
            btnAceptar.setText("Crear");
        } else {
            txtId.setEditable(false);
            txtId.setText(modelo.getId() + "");
            btnAceptar.setText("Modificar");

            txtMantenimientos.setText(modelo.getId_mantenimiento() + "");
            txtMaquinas.setText(modelo.getId_maquina() + "");
            txtTrabajadores.setText(modelo.getCc_trabajador() + "");

        }
    }

    private void llenarComboBoxs() {
        ConMantenimientos mante = new ConMantenimientos();
        arrayMantenimientos = mante.listar();
        for (Mantenimiento item : arrayMantenimientos) {
            cbMantenimientos.addItem(item.getId() + ":" + item.getCliente().getNombre());
        }
        ConMaquinas maquinas = new ConMaquinas();
        arrayMaquinas = maquinas.listar();
        for (Maquina item : arrayMaquinas) {
            cbMaquinas.addItem(item.getId() + ":" + item.getNombre());
        }
        ConTrabajadores trabajadores = new ConTrabajadores();
        arrayTrabajadores = trabajadores.listar();
        for (Trabajador item : arrayTrabajadores) {
            cbTrabajadores.addItem(item.getCc() + ":" + item.getNombre());
        }

    }

    private Maquinas_Mantenimiento getModelo() {
        if (isNew) {
            return new Maquinas_Mantenimiento(
                    Integer.parseInt(txtMantenimientos.getText()),
                    Integer.parseInt(txtMaquinas.getText()),
                    Integer.parseInt(txtTrabajadores.getText())
            );

        } else {
            return new Maquinas_Mantenimiento(
                    Integer.parseInt(txtId.getText()),
                    Integer.parseInt(txtMantenimientos.getText()),
                    Integer.parseInt(txtMaquinas.getText()),
                    Integer.parseInt(txtTrabajadores.getText()));
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

        txtMantenimientos1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbMantenimientos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbMaquinas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbTrabajadores = new javax.swing.JComboBox<>();
        txtTrabajadores = new javax.swing.JTextField();
        txtMaquinas = new javax.swing.JTextField();
        txtMantenimientos = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("MaquinasMantenimientoForm"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("ID");

        jLabel2.setText("Mantenimiento");

        cbMantenimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMantenimientosActionPerformed(evt);
            }
        });

        jLabel3.setText("Maquina");

        cbMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaquinasActionPerformed(evt);
            }
        });

        jLabel4.setText("Trabajador");

        cbTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrabajadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaquinas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbMaquinas, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                            .addComponent(txtMantenimientos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbMantenimientos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrabajadores)
                            .addComponent(cbTrabajadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMantenimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMantenimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAceptar)
                .addComponent(btnEliminar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMantenimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMantenimientosActionPerformed
        txtMantenimientos.setText(arrayMantenimientos.get(cbMantenimientos.getSelectedIndex()).getId() + "");
    }//GEN-LAST:event_cbMantenimientosActionPerformed

    private void cbMaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaquinasActionPerformed
        txtMaquinas.setText(arrayMaquinas.get(cbMaquinas.getSelectedIndex()).getId() + "");
    }//GEN-LAST:event_cbMaquinasActionPerformed

    private void cbTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrabajadoresActionPerformed
        txtTrabajadores.setText(arrayTrabajadores.get(cbTrabajadores.getSelectedIndex()).getCc() + "");
    }//GEN-LAST:event_cbTrabajadoresActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (isNew) {
            controlador.insert(getModelo());
        } else {
            controlador.update(getModelo());

        }
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        controlador.delete(getModelo());
        dispose();

    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbMantenimientos;
    private javax.swing.JComboBox<String> cbMaquinas;
    private javax.swing.JComboBox<String> cbTrabajadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMantenimientos;
    private javax.swing.JTextField txtMantenimientos1;
    private javax.swing.JTextField txtMaquinas;
    private javax.swing.JTextField txtTrabajadores;
    // End of variables declaration//GEN-END:variables

}
