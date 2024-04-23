/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cliente;
import Modelo.ConexionBD;
import Modelo.Detalle;
import Modelo.Factura;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coromoro
 */
public class FRMFactura extends javax.swing.JInternalFrame {

    int total = 0;
    int idf = 0;
    int sub = 0;
    int idp = 0;
    int cd = 0;

    /**
     * Creates new form FRMFactura
     */
    public FRMFactura() {
        initComponents();

        //cargaar clientes en el comboBox
        this.CargarClientes();
        this.llenarTabla();

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

    private void guardarFacturaEnBaseDeDatos() {
        Factura miF = new Factura();
        Calendar today = Calendar.getInstance();
        Date fechaHoy = new Date(today.getTimeInMillis());
        miF.setIdClienteFactura(((Cliente) combCliente.getSelectedItem()).getIdCliente());
        miF.setFechaFactura(fechaHoy);
        miF.setTotalFactura(total);
        idf = miF.insertar();
        System.out.println("id ultima factura " + idf);
    }

    private void guardardetalles() {
        Detalle mid;
        int tamaño = TBLSeleccion.getRowCount();
        System.out.println("tamaño de la tabla "+tamaño);
        for (int i = 0; i < tamaño; i++) {
           mid = new Detalle();
           mid.setIdFacturaDetalle(idf);
           mid.setIdProductoDetalle((int)TBLSeleccion.getValueAt(i, 2));
           mid.setSubTotalDetalle((int)TBLSeleccion.getValueAt(i, 4)*(int)TBLSeleccion.getValueAt(i, 5));
           mid.setCantidadDetalle((int)TBLSeleccion.getValueAt(i, 5));
           
            
           mid.insertar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BTNBuscar = new javax.swing.JButton();
        TXTBuscarProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBLSeleccion = new javax.swing.JTable();
        combCliente = new javax.swing.JComboBox<>();
        TXTcantidad = new javax.swing.JFormattedTextField();
        BTNFacturar = new javax.swing.JButton();
        TXTTotal = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Factura");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel1.setText("Seleccionar Producto");

        BTNBuscar.setText("Buscar");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

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

        TBLSeleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id Cliente", "Nombre Cliente", "id Producto ", "Nombre producto", "Precio Producto", "Cantidad Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLSeleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLSeleccionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TBLSeleccion);

        combCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combClienteActionPerformed(evt);
            }
        });

        TXTcantidad.setText("escriba la cantidad requerida");
        TXTcantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTcantidadFocusGained(evt);
            }
        });
        TXTcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTcantidadActionPerformed(evt);
            }
        });

        BTNFacturar.setText("Facturar");
        BTNFacturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNFacturarMouseClicked(evt);
            }
        });
        BTNFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNFacturarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TXTcantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69)
                        .addComponent(BTNBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BTNFacturar)
                        .addGap(67, 67, 67)
                        .addComponent(TXTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXTBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNBuscar)))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(combCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(TXTcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNFacturar)
                    .addComponent(TXTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed

    }//GEN-LAST:event_BTNBuscarActionPerformed

    private void TBLProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLProductoMouseClicked
        Cliente miCliente = (Cliente) combCliente.getSelectedItem();
        int cantidadObjetos = Integer.parseInt(TXTcantidad.getText());

        Object[] filaProducto = new Object[TBLSeleccion.getColumnCount()];
        DefaultTableModel tabla = (DefaultTableModel) TBLSeleccion.getModel();

        int filaSeleccionada = TBLProducto.getSelectedRow();
        if (filaSeleccionada != -1) {
            filaProducto[0] = miCliente.getIdCliente();
            filaProducto[1] = miCliente.getNombreCliente();
            filaProducto[2] = TBLProducto.getValueAt(filaSeleccionada, 0);
            filaProducto[3] = TBLProducto.getValueAt(filaSeleccionada, 1);
            filaProducto[4] = TBLProducto.getValueAt(filaSeleccionada, 2);
            filaProducto[5] = cantidadObjetos;
            tabla.addRow(filaProducto);
            total = total + cantidadObjetos * (int) TBLProducto.getValueAt(filaSeleccionada, 2);
            sub = cantidadObjetos * (int) TBLProducto.getValueAt(filaSeleccionada, 2);
           TXTTotal.setText(total + "");
        }
    }//GEN-LAST:event_TBLProductoMouseClicked

    private void TXTBuscarProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarProductoFocusGained
        TXTBuscarProducto.setText("");
        if (TXTBuscarProducto.getText().equals("escriba el texto a busca")) {
            TXTBuscarProducto.setText("");
        }
    }//GEN-LAST:event_TXTBuscarProductoFocusGained

    private void TXTBuscarProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarProductoFocusLost
        if (TXTBuscarProducto.getText().isEmpty()) {
            TXTBuscarProducto.setText("escriba el texto a busca");
        }
    }//GEN-LAST:event_TXTBuscarProductoFocusLost

    private void TXTBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTBuscarProductoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TXTBuscarProductoActionPerformed

    private void combClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combClienteActionPerformed

    private void TXTcantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTcantidadFocusGained
        TXTcantidad.setText("");
        if (TXTcantidad.getText().equals("escriba la cantidad requerida")) {
            TXTcantidad.setText("");
        }
    }//GEN-LAST:event_TXTcantidadFocusGained

    private void TBLSeleccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLSeleccionMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = TBLSeleccion.getSelectedRow();
        Object miO = TBLSeleccion.getSelectedRows();
        System.out.println("fila a elimi " + filaSeleccionada + " rows " + TBLSeleccion.getRowCount());

    }//GEN-LAST:event_TBLSeleccionMouseClicked

    private void BTNFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNFacturarActionPerformed
        guardarFacturaEnBaseDeDatos();
        guardardetalles();

    }//GEN-LAST:event_BTNFacturarActionPerformed

    private void BTNFacturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNFacturarMouseClicked

    }//GEN-LAST:event_BTNFacturarMouseClicked

    private void TXTcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTcantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNFacturar;
    private javax.swing.JTable TBLProducto;
    private javax.swing.JTable TBLSeleccion;
    private javax.swing.JTextField TXTBuscarProducto;
    private javax.swing.JTextField TXTTotal;
    private javax.swing.JFormattedTextField TXTcantidad;
    private javax.swing.JComboBox<Cliente> combCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void CargarClientes() {
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM cliente " + this.getClass().getSimpleName());

            ResultSet rs = sql.executeQuery();
            combCliente.removeAllItems();
            Cliente miC = new Cliente();
            miC.setNombreCliente("Seleccione un cliente");
            combCliente.addItem(miC);
            while (rs.next()) {
                miC = new Cliente();
                miC.setIdCliente(rs.getInt("idCliente"));
                miC.setNombreCliente(rs.getString("nombreCliente"));
                miC.setDocumentoCliente(rs.getString("documentoCliente"));
                combCliente.addItem(miC);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar " + e.toString());
        }
    }
}
