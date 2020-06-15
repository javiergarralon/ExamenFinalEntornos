/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author alvar
 */
public class PedidosDao {

    private Connection conexion = null;

    //establecemos la conexion
    public PedidosDao() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptuno", "root", "");

        } catch (SQLException e) {
            System.out.println("Error al conectar..." + e.getMessage());
        }
    }

    //comprobamos la conexion 
    public Connection getConexion() {
        return conexion;
    }

    //Este es el read
    public Pedido read(Integer idPedido) {
        Pedido pedido = null;
        PreparedStatement stmt = null;

        if (this.conexion == null) {
            return null;
        }

        try {
            String select = "SELECT * FROM pedidos WHERE id = ?";
            stmt = conexion.prepareStatement(select);
            stmt.setInt(1, idPedido);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("empleado_id"),
                        rs.getDate("fecha_pedido"),
                        rs.getDate("fecha_entrega"),
                        rs.getDate("fecha_envio"),
                        rs.getInt("envio_id"),
                        rs.getBigDecimal("cargo"),
                        rs.getString("destinatario"),
                        rs.getString("direccion_destinatario"),
                        rs.getString("ciudad_destinatario"),
                        rs.getString("region_destinatario"),
                        rs.getString("cp_destinatario"),
                        rs.getString("pais_destinatario")
                );
            }

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pedido;
    }

    //CREAR
    public Integer insert(Pedido pedido) {

        Integer resultado = null;
        PreparedStatement stmt = null;
        Integer ultimoID = null;

        if (this.conexion == null || pedido == null) {
            return null;
        }

        try {
            String sql = "INSERT INTO pedidos "
                    + "(cliente_id, empleado_id, fecha_pedido, fecha_entrega, fecha_envio, envio_id, cargo, destinatario, direccion_destinatario, "
                    + "ciudad_destinatario, region_destinatario, cp_destinatario, pais_destinatario) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            stmt.setInt(1, empleado.getCodigoEmpleado());
            stmt.setInt(1, pedido.getCliente_id());
            stmt.setInt(2, pedido.getEmpleado_id());
            stmt.setDate(3, (Date) pedido.getFechaPedido());
            stmt.setDate(4, (Date) pedido.getFechaEntrega());
            stmt.setDate(5, (Date) pedido.getFechaEnvio());
            if (pedido.getEnvio_id() == null) {
                stmt.setNull(6, Types.INTEGER);
            } else {
                stmt.setInt(6, pedido.getEnvio_id());
            }
            stmt.setBigDecimal(7, pedido.getCargo());
            stmt.setString(8, pedido.getDestinatario());
            stmt.setString(9, pedido.getDireccionDestinatario());
            stmt.setString(10, pedido.getCiudadDestinatario());
            stmt.setString(11, pedido.getRegionDestinatario());
            stmt.setString(12, pedido.getCpDestinatario());
            stmt.setString(13, pedido.getPaisDestinatario());

            if (stmt.executeUpdate() > 0) {
                // Ahora leeo el valor de la última clave insertada
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    resultado = rs.getInt(1);
                }

            };

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return resultado;
    }

    //UPDATE
    public Integer update(Pedido pedido) {
        Integer resultado = 0;
        PreparedStatement stmt = null;

        if (this.conexion == null || pedido == null) {
            return resultado;
        }

        try {
            String sql = "UPDATE pedidos SET cliente_id = ?, empleado_id = ?, fecha_pedido = ?, "
                    + "fecha_entrega = ?, fecha_envio = ?, envio_id = ?,  cargo = ?, destinatario = ?, "
                    + "direccion_destinatario = ?, ciudad_destinatario = ?, region_destinatario  = ?, "
                    + "cp_destinatario = ?, pais_destinatario = ? WHERE id = ?";

            stmt = conexion.prepareStatement(sql);
//            stmt.setInt(1, empleado.getCodigoEmpleado());
            stmt.setInt(1, pedido.getCliente_id());
            stmt.setInt(2, pedido.getEmpleado_id());
            stmt.setDate(3, (Date) pedido.getFechaPedido());
            stmt.setDate(4, (Date) pedido.getFechaEntrega());
            stmt.setDate(5, (Date) pedido.getFechaEnvio());
            if (pedido.getEnvio_id() == null) {
                stmt.setNull(6, Types.INTEGER);
            } else {
                stmt.setInt(6, pedido.getEnvio_id());
            }
            stmt.setBigDecimal(7, pedido.getCargo());
            stmt.setString(8, pedido.getDestinatario());
            stmt.setString(9, pedido.getDireccionDestinatario());
            stmt.setString(10, pedido.getCiudadDestinatario());
            stmt.setString(11, pedido.getRegionDestinatario());
            stmt.setString(12, pedido.getCpDestinatario());
            stmt.setString(13, pedido.getPaisDestinatario());

            stmt.setInt(14, pedido.getId());

            resultado = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return resultado;
    }

    //DELETE
    public Integer delete(Integer idPedido) {
        Integer resultado = 0;
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM pedidos WHERE id = ?";

            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idPedido);

            resultado = stmt.executeUpdate();

            stmt.close();

            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    //LISTAR
    public ArrayList<Pedido> listar(Integer posicion) {
        Pedido pedido = null;
        ArrayList<Pedido> lista = new ArrayList<>();
        PreparedStatement stmt = null;

        if (this.getConexion() == null) {
            return null;
        }

        try {
            String select = "SELECT pedidos.id,cliente_id, clientes.empresa, empleado_id,"
                    + "fecha_pedido,fecha_entrega,fecha_envio,envio_id, cargo,destinatario,"
                    + "direccion_destinatario,ciudad_destinatario,region_destinatario,cp_destinatario,pais_destinatario "
                    + "FROM pedidos JOIN clientes on pedidos.cliente_id= clientes.id order by clientes.empresa LIMIT 10 OFFSET ?";
            stmt = conexion.prepareStatement(select);
            stmt.setInt(1, posicion);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("empleado_id"),
                        rs.getDate("fecha_pedido"),
                        rs.getDate("fecha_entrega"),
                        rs.getDate("fecha_envio"),
                        rs.getInt("envio_id"),
                        rs.getBigDecimal("cargo"),
                        rs.getString("destinatario"),
                        rs.getString("direccion_destinatario"),
                        rs.getString("ciudad_destinatario"),
                        rs.getString("region_destinatario"),
                        rs.getString("cp_destinatario"),
                        rs.getString("pais_destinatario")
                );
                lista.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Sentencia incorrecta: " + e.getMessage());
        }

        return lista;

    }
}
