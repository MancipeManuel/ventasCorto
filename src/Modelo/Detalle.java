/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author coromoro
 */
public class Detalle {
    private int idDetalle;
    private int idFacturaDetalle;
    private int idProductoDetalle;
    private int subTotalDetalle;
    private int cantidadDetalle;

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    
    public int getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(int idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public int getIdProductoDetalle() {
        return idProductoDetalle;
    }

    public void setIdProductoDetalle(int idProductoDetalle) {
        this.idProductoDetalle = idProductoDetalle;
    }

    public int getSubTotalDetalle() {
        return subTotalDetalle;
    }

    public void setSubTotalDetalle(int subTotalDetalle) {
        this.subTotalDetalle = subTotalDetalle;
    }

    public int getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    @Override
    public String toString() {
        return "Detalle{" + "idFacturaDetalle=" + idFacturaDetalle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Detalle other = (Detalle) obj;
        return this.idFacturaDetalle == other.idFacturaDetalle;
    }
     public Iterator<Detalle>listar(int idFactura){
         System.out.println("entra al listar");
        ArrayList<Detalle> losDetalles = new ArrayList<>();
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement("SELECT * FROM detalle where idFacturaDetalle = ?");
            sql.setInt(1, idFactura);
            System.out.println("paso la condulta "+sql);
            ResultSet rs = sql.executeQuery();
            Detalle unDetalle;
            while (rs.next()){
                unDetalle = new Detalle();
                unDetalle.setIdFacturaDetalle(rs.getInt   ("idFacturaDetalle"));
                unDetalle.setIdProductoDetalle(rs.getInt("idProductoDetalle"));
                unDetalle.setSubTotalDetalle(rs.getInt("subTotalDetalle"));
                unDetalle.setCantidadDetalle(rs.getInt("cantidadDetalle"));
                losDetalles.add(unDetalle);
            }
        }catch (SQLException ex){
            System.err.println("Error al listar"+ex.getMessage());
        }
        return losDetalles.iterator();
    }
    public void insertar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "
                    +this.getClass().getSimpleName()+" VALUES(?,?,?,?)");
            sql.setInt(1, this.getIdFacturaDetalle());
            sql.setInt(2, this.getIdProductoDetalle());
            sql.setInt(3, this.getSubTotalDetalle());
            sql.setInt(4, this.getCantidadDetalle());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"insertado correctamente");
        }catch(SQLException ex){
            System.err.println("error al insertar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void modificar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                    " SET idDetalle =?,idFacturaDetalle =?,idProductoDetalle =?,subTotalDetalle =?,cantidadDetalle =? WHERE idDetalle =?");
            sql.setInt(1, this.getIdDetalle());
            sql.setInt(2, this.getIdFacturaDetalle());
            sql.setInt(3, this.getIdProductoDetalle());
            sql.setInt(4, this.getSubTotalDetalle());
            sql.setInt(5, this.getCantidadDetalle());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"modificado correctamente");
        }catch(SQLException ex){
            System.err.println("error al modificar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" DELETE FROM "
                    +this.getClass().getSimpleName()+" WHERE idDetalle = ?");
            sql.setInt(1,getIdDetalle());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("error al elimminar"+this .getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Detalle> buscar (String busqueda){
        ArrayList<Detalle> losDetalles = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName()
            +" WHERE idDetalle LIKE ? OR idFacturaDetalle LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            ResultSet rs =sql.executeQuery();
            Detalle unDetalle;
            while (rs.next()){
                unDetalle=new Detalle();
                unDetalle.setIdDetalle(rs.getInt ("idDetalle"));
                unDetalle.setIdFacturaDetalle(rs.getInt("idFacturaDetalle"));
                unDetalle.setIdProductoDetalle(rs.getInt("idProductoDetalle"));
                unDetalle.setSubTotalDetalle(rs.getInt("subTotalDetalle"));
                unDetalle.setCantidadDetalle(rs.getInt("cantidadDetalle"));
                losDetalles.add(unDetalle);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar" +this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return losDetalles.iterator();
    }
    public Detalle buscarPorID (int elID){
         Detalle unDetalle=new Detalle();
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement(" SELECT * FROM "+
                    this.getClass().getSimpleName()+" WHERE idDetalle = ? ");
            sql.setInt(1, elID);
            ResultSet rs =sql.executeQuery();
            while (rs.next()){
                unDetalle.setIdDetalle(rs.getInt("idDetalle"));
                unDetalle.setIdFacturaDetalle(rs.getInt("idFacturaDetalle"));
                unDetalle.setIdProductoDetalle(rs.getInt("idProductoDetalle"));
                unDetalle.setSubTotalDetalle(rs.getInt("subTotalDetalle"));
            }
        }catch (SQLException ex){
            System.err.println("error al buscar el id"+ex.getMessage());
        }
        return unDetalle;
    }

    public void setIdProductoDetalle(String idp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



