/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorProducto;
import Modelo.Cliente;
import Modelo.Producto;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coromoro
 */
public class FRMProductos extends javax.swing.JInternalFrame {
        
    ControladorProducto productoContoller= new ControladorProducto();
    
    public FRMProductos() {
        initComponents();
        TXTidProducto.setValue(0);
        TXTidProducto.setVisible(false);
        limpiarFormulario();
    }
    private void limpiarFormulario() {
        TXTidProducto.setValue(0);
        TXTNombreProducto.setText("escriba nombre");
        TXTBuscarProducto.setText("escriba el texto a buscar");
        BTNModificar.setEnabled(false);
        BTNEliminar.setEnabled(false);
        llenarTabla();
    }

    public void llenarTabla() {
        Producto unProducto = new Producto();
        DefaultTableModel tabla = (DefaultTableModel) TBLProducto.getModel();
        Iterator<Producto> itProducto = unProducto.listar();
        Object[] filaProducto = new Object[TBLProducto.getColumnCount()];
        tabla.setRowCount(0);
        while (itProducto.hasNext()) {
            unProducto = itProducto.next();
            filaProducto[0] = unProducto.getIdProducto();
            filaProducto[1] = unProducto.getNombreProducto();
            filaProducto[2] = unProducto.getPrecioProducto();
            tabla.addRow(filaProducto);
        }
    }

    private Producto obtenerProducto() {
        Producto elProducto = new Producto();
        elProducto.setIdProducto((Integer) TXTidProducto.getValue());
        elProducto.setNombreProducto(TXTNombreProducto.getText());
        elProducto.setPrecioProducto(Integer.parseInt(TXTPrecioProducto.getText()));
        return elProducto;
    }
    
    private void llenarTablaConBusqueda(String busqueda){
        Producto unProducto = new Producto();
        DefaultTableModel tabla = (DefaultTableModel)TBLProducto.getModel();
        Iterator<Producto> itClientes = unProducto.buscar(busqueda);
        Object[]filaCliente = new Object[TBLProducto.getColumnCount()];
        tabla.setRowCount(0);
        while(itClientes.hasNext()){
            unProducto=itClientes.next();
            filaCliente[0]=unProducto.getIdProducto();
            filaCliente[1]=unProducto.getNombreProducto();
            filaCliente[2]=unProducto.getPrecioProducto();
            ((DefaultTableModel)TBLProducto.getModel()).addRow(filaCliente);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBLNombreProducto = new javax.swing.JLabel();
        LBLPrecioProducto = new javax.swing.JLabel();
        TXTNombreProducto = new javax.swing.JTextField();
        TXTidProducto = new javax.swing.JFormattedTextField();
        TXTPrecioProducto = new javax.swing.JTextField();
        LBLBuscarProducto = new javax.swing.JLabel();
        TXTBuscarProducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        BTNInsertar = new javax.swing.JButton();
        BTNModificar = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();
        BTNCerrar = new javax.swing.JButton();
        BTNBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLProducto = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Formato Producto");

        LBLNombreProducto.setText("Nombre Producto");

        LBLPrecioProducto.setText("Precio Producto");

        TXTNombreProducto.setText("ingrese nombre");

        TXTidProducto.setText("0");
        TXTidProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTidProductoActionPerformed(evt);
            }
        });

        TXTPrecioProducto.setText("Ingrese precio");
        TXTPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTPrecioProductoActionPerformed(evt);
            }
        });

        LBLBuscarProducto.setText("Buscar Producto");

        TXTBuscarProducto.setText("Ingrese Busqueda");
        TXTBuscarProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTBuscarProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTBuscarProductoFocusLost(evt);
            }
        });
        TXTBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBLNombreProducto)
                    .addComponent(LBLPrecioProducto)
                    .addComponent(LBLBuscarProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXTNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TXTPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLNombreProducto)
                    .addComponent(TXTNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLPrecioProducto)
                    .addComponent(TXTPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLBuscarProducto)
                    .addComponent(TXTBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
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

        TBLProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id Producto", "Nombre Producto", "Precio Poducto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Byte.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLProducto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNInsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNCerrar)
                .addGap(18, 18, 18)
                .addComponent(BTNBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNInsertar)
                    .addComponent(BTNModificar)
                    .addComponent(BTNEliminar)
                    .addComponent(BTNCerrar)
                    .addComponent(BTNBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNInsertarActionPerformed
        productoContoller.controladorAccion(evt, obtenerProducto());
        limpiarFormulario();
    }//GEN-LAST:event_BTNInsertarActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
        productoContoller.controladorAccion(evt, obtenerProducto());
        limpiarFormulario();
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        productoContoller.controladorAccion(evt, obtenerProducto());
        limpiarFormulario();
    }//GEN-LAST:event_BTNEliminarActionPerformed

    private void BTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCerrarActionPerformed
        doDefaultCloseAction();
    }//GEN-LAST:event_BTNCerrarActionPerformed

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        llenarTablaConBusqueda(TXTBuscarProducto.getText());
    }//GEN-LAST:event_BTNBuscarActionPerformed

    private void TXTPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTPrecioProductoActionPerformed

    private void TXTidProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTidProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTidProductoActionPerformed

    private void TXTBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTBuscarProductoActionPerformed

    private void TBLProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLProductoMouseClicked
                if (evt.getClickCount()==2){
            int fila =TBLProducto.rowAtPoint(evt.getPoint());
            if(fila>-1){
                TXTidProducto.setValue((Integer) TBLProducto.getValueAt(fila, 0));
                TXTNombreProducto.setText((String) TBLProducto.getValueAt(fila, 1));
                TXTPrecioProducto.setText(TBLProducto.getValueAt(fila, 2)+"");
                BTNEliminar.setEnabled(true);
                BTNModificar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_TBLProductoMouseClicked

    private void TXTBuscarProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarProductoFocusGained
        if(TXTBuscarProducto.getText().equals("escriba el texto a busca")){
        TXTBuscarProducto.setText("");
        }
    }//GEN-LAST:event_TXTBuscarProductoFocusGained

    private void TXTBuscarProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarProductoFocusLost
        if(TXTBuscarProducto.getText().isEmpty()){
        TXTBuscarProducto.setText("escriba el texto a busca");
        }
    }//GEN-LAST:event_TXTBuscarProductoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNCerrar;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNInsertar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JLabel LBLBuscarProducto;
    private javax.swing.JLabel LBLNombreProducto;
    private javax.swing.JLabel LBLPrecioProducto;
    private javax.swing.JTable TBLProducto;
    private javax.swing.JTextField TXTBuscarProducto;
    private javax.swing.JTextField TXTNombreProducto;
    private javax.swing.JTextField TXTPrecioProducto;
    private javax.swing.JFormattedTextField TXTidProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
