/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author smlar
 */
public class Pedido {

    private Integer id;
    private Integer cliente_id;
    private Integer empleado_id;
    private Date fechaPedido;
    private Date fechaEntrega;
    private Date fechaEnvio;
    private Integer envio_id;
    private BigDecimal cargo;
    private String destinatario;
    private String direccionDestinatario;
    private String ciudadDestinatario;
    private String regionDestinatario;
    private String cpDestinatario;
    private String paisDestinatario;
    private ArrayList<Detalle> detallesList;

    public Pedido() {
    }

    public Pedido(Integer id, Integer cliente_id, Integer empleado_id, Date fechaPedido, Date fechaEntrega, Date fechaEnvio,
            Integer envio_id, BigDecimal cargo, String destinatario, String direccionDestinatario, String ciudadDestinatario,
            String regionDestinatario, String cpDestinatario, String paisDestinatario) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.empleado_id = empleado_id;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.fechaEnvio = fechaEnvio;
        this.envio_id = envio_id;
        this.cargo = cargo;
        this.destinatario = destinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.ciudadDestinatario = ciudadDestinatario;
        this.regionDestinatario = regionDestinatario;
        this.cpDestinatario = cpDestinatario;
        this.paisDestinatario = paisDestinatario;
        this.detallesList = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Integer getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(Integer empleado_id) {
        this.empleado_id = empleado_id;
    }

    public Integer getEnvio_id() {
        return envio_id;
    }

    public void setEnvio_id(Integer envio_id) {
        this.envio_id = envio_id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getCiudadDestinatario() {
        return ciudadDestinatario;
    }

    public void setCiudadDestinatario(String ciudadDestinatario) {
        this.ciudadDestinatario = ciudadDestinatario;
    }

    public String getRegionDestinatario() {
        return regionDestinatario;
    }

    public void setRegionDestinatario(String regionDestinatario) {
        this.regionDestinatario = regionDestinatario;
    }

    public String getCpDestinatario() {
        return cpDestinatario;
    }

    public void setCpDestinatario(String cpDestinatario) {
        this.cpDestinatario = cpDestinatario;
    }

    public String getPaisDestinatario() {
        return paisDestinatario;
    }

    public void setPaisDestinatario(String paisDestinatario) {
        this.paisDestinatario = paisDestinatario;
    }

    public ArrayList<Detalle> getDetallesList() {
        return detallesList;
    }

    public void setDetallesList(ArrayList<Detalle> detallesList) {
        this.detallesList = detallesList;
    }

}
