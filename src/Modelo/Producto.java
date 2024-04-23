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
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int precioProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public String toString() {
        return "Productos{" + "nombreProducto=" + nombreProducto + '}';
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
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }
     public Iterator<Producto>listar(){
        ArrayList<Producto> losProdutos = new ArrayList<>();
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Producto unProducto;
            while (rs.next()){
                unProducto = new Producto();
                unProducto.setIdProducto(rs.getInt   ("idProducto"));
                unProducto.setNombreProducto(rs.getString ("nombreProducto"));
                unProducto.setPrecioProducto(rs.getInt ("precioProducto"));
                losProdutos.add(unProducto);
            }
        }catch (SQLException ex){
            System.err.println("Error al listar"+ex.getMessage());
        }
        if (losProdutos.isEmpty()){
            Producto miProducto = new Producto();
            miProducto.setNombreProducto("No hay Productos");
            losProdutos.add(miProducto);
        }
        return losProdutos.iterator();
    }
    public void insertar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "
                    +this.getClass().getSimpleName()+" VALUES(NULL,?,?)");
            sql.setString(1, this.getNombreProducto());
            sql.setInt(2, this.getPrecioProducto());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"insertado correctamente");
        }catch(SQLException ex){
            System.err.println("error al insertar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void modificar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                    " SET nombreProducto =?,precioProducto =? WHERE idProducto =?");
            sql.setString(1, this.getNombreProducto());
            sql.setInt(2, this.getPrecioProducto());
            sql.setInt(3, this.getIdProducto());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"modificado correctamente");
        }catch(SQLException ex){
            System.err.println("error al modificar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" DELETE FROM "
                    +this.getClass().getSimpleName()+" WHERE idProducto = ?");
            sql.setInt(1,getIdProducto());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("error al elimminar"+this .getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Producto> buscar (String busqueda){
        ArrayList<Producto> losProductos = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName()
            +" WHERE nombreProducto LIKE ? OR precioProducto LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            ResultSet rs =sql.executeQuery();
            Producto unProducto;
            while (rs.next()){
                unProducto=new Producto();
                unProducto.setIdProducto(rs.getInt ("idProducto"));
                unProducto.setNombreProducto(rs.getString("nombreProducto"));
                unProducto.setPrecioProducto(rs.getInt("precioProducto"));
                losProductos.add(unProducto);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar" +this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return losProductos.iterator();
    }
    public Producto buscarPorID (int elID){
        Producto unProducto=new Producto();
        unProducto.setNombreProducto("Producto no existe");
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement(" SELECT * FROM "+
                    this.getClass().getSimpleName()+" WHERE idProducto = ? ");
            sql.setInt(1, elID);
            ResultSet rs =sql.executeQuery();
            while (rs.next()){
                unProducto.setIdProducto(rs.getInt("idProducto"));
                unProducto.setNombreProducto(rs.getString("nombreProducto"));
                unProducto.setPrecioProducto(rs.getInt("precioProducto"));
            }
        }catch (SQLException ex){
            System.err.println("error al buscar el id"+ex.getMessage());
        }
        return unProducto;
    }
}