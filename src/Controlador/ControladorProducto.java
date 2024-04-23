/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import java.awt.event.ActionEvent;

/**
 *
 * @author coromoro
 */
public class ControladorProducto {
    public void controladorAccion(ActionEvent evento,Producto unProducto){
        String accion=evento.getActionCommand();
        switch(accion){
            case "Insertar":
                unProducto.insertar();
            break;
            case "Modificar":
                unProducto.modificar();
            break;
            case "Eliminar":
                unProducto.eliminar();
            break;
        }
    }
}
