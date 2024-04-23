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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coromoro
 */
public class FRMDetalle extends javax.swing.JInternalFrame {
    
    int idFactura=0;
    int idcliente=0;
    
    
    public FRMDetalle() {
        initComponents();
        CargarFacturas();
        
    }

public void llenarTabla() {
    Detalle unDetalle = new Detalle();
    DefaultTableModel tabla = (DefaultTableModel) TBLDetalle.getModel();
    Iterator<Detalle> itDetalle = unDetalle.listar(idFactura);
    Object[] filaProducto = new Object[TBLDetalle.getColumnCount()];
    tabla.setRowCount(0);
    while (itDetalle.hasNext()) {
        unDetalle = itDetalle.next();
        Producto mip = new Producto();
        mip = mip.buscarPorID(unDetalle.getIdProductoDetalle());
        filaProducto[0] = unDetalle.getIdProductoDetalle();
        filaProducto[1] = mip.getNombreProducto();
        filaProducto[2] = mip.getPrecioProducto();
        filaProducto[3] = unDetalle.getCantidadDetalle();
        filaProducto[4] = unDetalle.getSubTotalDetalle();
        tabla.addRow(filaProducto);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComFacturas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLDetalle = new javax.swing.JTable();
        LBLNombre = new javax.swing.JLabel();
        LBLFecha = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Detalle");

        ComFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComFacturasMouseClicked(evt);
            }
        });
        ComFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComFacturasActionPerformed(evt);
            }
        });

        TBLDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id Producto", "Nombre producto", "Precio Producto", "cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TBLDetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(LBLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(LBLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LBLFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBLNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComFacturasActionPerformed
        Factura mif =(Factura)ComFacturas.getSelectedItem();
        idFactura=mif.getIdFactura();
        LBLFecha.setText(mif.getFechaFactura()+""); 
        idcliente=(int)mif.getIdClienteFactura();
        optenerCliente();
        
        System.out.println("entra a action performace"+mif.getIdFactura());
        llenarTabla();
    }//GEN-LAST:event_ComFacturasActionPerformed

    private void ComFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComFacturasMouseClicked
        
    }//GEN-LAST:event_ComFacturasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Factura> ComFacturas;
    private javax.swing.JLabel LBLFecha;
    private javax.swing.JLabel LBLNombre;
    private javax.swing.JTable TBLDetalle;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private void optenerCliente(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM cliente where idCliente = ?");
            sql.setInt(1, idcliente);
            System.out.println("id cliente"+idcliente);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombreCliente(rs.getString("nombreCliente"));
                cliente.setDocumentoCliente(rs.getString("documentoCliente"));
                LBLNombre.setText(cliente.getNombreCliente());
            }
                
        } catch (Exception e) {
            System.out.println("Error al cargar " + e.toString());
        }
    }
   
    
    private void CargarFacturas() {
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM factura " + this.getClass().getSimpleName());

            ResultSet rs = sql.executeQuery();
            ComFacturas.removeAllItems();
            Factura mif = new Factura();
            mif.setIdFactura(0);
            ComFacturas.addItem(mif);
            while (rs.next()) {
                mif = new Factura();
                mif.setIdFactura(rs.getInt("idfactura"));
                mif.setTotalFactura(rs.getInt("totalFactura"));
                mif.setFechaFactura(rs.getDate("fechafactura"));
                mif.setIdClienteFactura(rs.getInt("idClienteFactura"));
                ComFacturas.addItem(mif);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar " + e.toString());
        }
    }
}
