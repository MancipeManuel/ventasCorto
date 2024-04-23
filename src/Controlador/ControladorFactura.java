/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Factura;
import java.awt.event.ActionEvent;

public class ControladorFactura {
     public void controladorAccion(ActionEvent evento,Factura unaFactura){
        String accion=evento.getActionCommand();
        switch(accion){
            case "Insertar":
                unaFactura.insertar();
            break;
            case "Modificar":
                unaFactura.modificar();
            break;
            case "Eliminar":
                unaFactura.eliminar();
            break;
        }
    }
}
