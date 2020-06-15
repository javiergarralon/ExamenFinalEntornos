/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;


/**
 *
 * @author smlar
 */
public class Detalle {
    private Integer pedido_id;
    private Integer producto_id;
    
    private BigDecimal precioUnidad;
    private Short cantidad;
    private Double descuento;

    public Detalle() {
    }

    public Detalle(Integer pedido_id, Integer producto_id, BigDecimal precioUnidad, Short cantidad, Double descuento) {
        this.pedido_id = pedido_id;
        this.producto_id = producto_id;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }


    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
}
