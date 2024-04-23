/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCliente;
import Modelo.Cliente;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coromoro
 */
public class FRMCliente extends javax.swing.JInternalFrame {
    
    ControladorCliente clienteController = new ControladorCliente();
    
    public FRMCliente() {
        initComponents();
        TXTIdCliente.setValue(0);
        TXTIdCliente.setVisible(false);
        limpiarFormulario();
    }
    
    private void limpiarFormulario() {
        TXTIdCliente.setValue(0);
        TXTNombreCliente.setText("escriba nombre");
        TXTDocumentoCliente.setText("escriba documento");
        TXTBuscarCliente.setText("escriba el texto a buscar");
        BTNModificar.setEnabled(false);
        BTNEliminar.setEnabled(false);
        llenarTabla();
    }

    public void llenarTabla() {
        Cliente unCliente = new Cliente();
        DefaultTableModel tabla = (DefaultTableModel) TBLCliente.getModel();
        Iterator<Cliente> itCliente = unCliente.listar();
        Object[] filaCliente = new Object[TBLCliente.getColumnCount()];
        tabla.setRowCount(0);
        while (itCliente.hasNext()) {
            unCliente = itCliente.next();
            filaCliente[0] = unCliente.getIdCliente();
            filaCliente[1] = unCliente.getNombreCliente();
            filaCliente[2] = unCliente.getDocumentoCliente();
            tabla.addRow(filaCliente);
        }
    }

    private Cliente obtenerCliente() {
        Cliente elCliente = new Cliente();
        elCliente.setIdCliente((Integer) TXTIdCliente.getValue());
        elCliente.setNombreCliente(TXTNombreCliente.getText());
        elCliente.setDocumentoCliente(TXTDocumentoCliente.getText());
        return elCliente;
    }
    
    private void llenarTablaConBusqueda(String busqueda){
        Cliente unCliente = new Cliente();
        DefaultTableModel tabla = (DefaultTableModel)TBLCliente.getModel();
        Iterator<Cliente> itClientes = unCliente.buscar(busqueda);
        Object[] filaCliente = new Object[TBLCliente.getColumnCount()];
        tabla.setRowCount(0);
        while(itClientes.hasNext()){
            unCliente=itClientes.next();
            filaCliente[0]=unCliente.getIdCliente();
            filaCliente[1]=unCliente.getNombreCliente();
            filaCliente[2]=unCliente.getDocumentoCliente();
            ((DefaultTableModel)TBLCliente.getModel()).addRow(filaCliente);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBLNombre = new javax.swing.JLabel();
        LBLDocumento = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTNombreCliente = new javax.swing.JTextField();
        TXTDocumentoCliente = new javax.swing.JTextField();
        LBLBuscar = new javax.swing.JLabel();
        TXTIdCliente = new javax.swing.JFormattedTextField();
        TXTBuscarCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BTNInsertar = new javax.swing.JButton();
        BTNModificar = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();
        BTNCerrar = new javax.swing.JButton();
        BTNBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLCliente = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Cliente");

        LBLNombre.setText("Nombre");

        LBLDocumento.setText("Documento");

        TXTNombreCliente.setText("Escriba Nombre");
        TXTNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTNombreClienteActionPerformed(evt);
            }
        });

        TXTDocumentoCliente.setText("Escriba Documento");
        TXTDocumentoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTDocumentoClienteActionPerformed(evt);
            }
        });

        LBLBuscar.setText("Buscar");

        TXTIdCliente.setText("0");
        TXTIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTIdClienteActionPerformed(evt);
            }
        });

        TXTBuscarCliente.setText("Escriba el texto a buscar");
        TXTBuscarCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTBuscarClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTBuscarClienteFocusLost(evt);
            }
        });
        TXTBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBLDocumento)
                            .addComponent(LBLNombre)
                            .addComponent(LBLBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TXTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TXTIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TXTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLNombre)
                    .addComponent(TXTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLDocumento)
                    .addComponent(TXTDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLBuscar)
                    .addComponent(TXTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BTNInsertar.setText("Insertar");
        BTNInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNInsertarActionPerformed(evt);
            }
        });

        BTNModificar.setText("Modificar");
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        BTNEliminar.setText("Eliminar");
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        BTNCerrar.setText("Cerrar");
        BTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCerrarActionPerformed(evt);
            }
        });

        BTNBuscar.setText("Buscar");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNInsertar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTNModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTNEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTNCerrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTNBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNInsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TBLCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id Cliente", "Nombre Cliente", "Documento Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTNombreClienteActionPerformed

    private void TXTDocumentoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTDocumentoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTDocumentoClienteActionPerformed

    private void BTNInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNInsertarActionPerformed
        clienteController.controladorAccion(evt, obtenerCliente());
        limpiarFormulario();
    }//GEN-LAST:event_BTNInsertarActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
        clienteController.controladorAccion(evt, obtenerCliente());
        limpiarFormulario();
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        clienteController.controladorAccion(evt, obtenerCliente());
        limpiarFormulario();
    }//GEN-LAST:event_BTNEliminarActionPerformed

    private void BTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCerrarActionPerformed
        doDefaultCloseAction();
    }//GEN-LAST:event_BTNCerrarActionPerformed

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        llenarTablaConBusqueda(TXTBuscarCliente.getText());
    }//GEN-LAST:event_BTNBuscarActionPerformed

    private void TXTIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTIdClienteActionPerformed

    private void TXTBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTBuscarClienteActionPerformed

    private void TBLClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLClienteMouseClicked
        if (evt.getClickCount()==2){
            int fila =TBLCliente.rowAtPoint(evt.getPoint());
            if(fila>-1){
                TXTIdCliente.setValue((Integer) TBLCliente.getValueAt(fila, 0));
                TXTNombreCliente.setText((String) TBLCliente.getValueAt(fila, 1));
                TXTDocumentoCliente.setText((String) TBLCliente.getValueAt(fila, 2));
                BTNEliminar.setEnabled(true);
                BTNModificar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_TBLClienteMouseClicked

    private void TXTBuscarClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarClienteFocusGained
        if(TXTBuscarCliente.getText().equals("Escriba texto a buscar")){
            TXTBuscarCliente.setText("");
        }
    }//GEN-LAST:event_TXTBuscarClienteFocusGained

    private void TXTBuscarClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarClienteFocusLost
        if(TXTBuscarCliente.getText().isEmpty()){
            TXTBuscarCliente.setText("Escriba el texto a buscar");
        }
    }//GEN-LAST:event_TXTBuscarClienteFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNCerrar;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNInsertar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JLabel LBLBuscar;
    private javax.swing.JLabel LBLDocumento;
    private javax.swing.JLabel LBLNombre;
    private javax.swing.JTable TBLCliente;
    private javax.swing.JTextField TXTBuscarCliente;
    private javax.swing.JTextField TXTDocumentoCliente;
    private javax.swing.JFormattedTextField TXTIdCliente;
    private javax.swing.JTextField TXTNombreCliente;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
