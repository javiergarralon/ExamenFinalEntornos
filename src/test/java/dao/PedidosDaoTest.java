/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javi
 */
public class PedidosDaoTest {

    static PedidosDao pedidos = new PedidosDao();
    static Pedido pedido = new Pedido(9999, 90, 5, new Date(1970 - 01 - 01), new Date(1970 - 01 - 01), new Date(1970 - 01 - 01), 1,
            new BigDecimal(110.10), "prueba", "prueba", "prueba", "prueba", "prueba", "prueba");

    public PedidosDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class PedidosDao.
     */
    @Test
    public void testRead() {
        System.out.println("READ");
        Integer id = 1; //no existe
        Pedido result = pedidos.read(id);
        assertEquals(result, null);
        id = 11073;
        result = pedidos.read(id);
        assertEquals(result.getId(), id);

    }

    /**
     * Test of insert method, of class PedidosDao.
     */
    @Test
    public void testInsert() {
        System.out.println("INSERT");

        Integer result = pedidos.insert(pedido);
        assertNotNull(result);
        //como el id se asigna automatico no puede ser el mismo que el del objeto
        assertNotEquals(result, pedido.getId());
        //Borrar la prueba segun el id que se le haya asignado
        System.out.println("Borrando registro al finalizar");
        pedidos.delete(result);
    }

    /**
     * Test of delete method, of class PedidosDao.
     */
    @Test
    public void testDelete() {
        System.out.println("DELETE");

        int result = pedidos.delete(pedido.getId());
        assertNotEquals(result, -1);

        result = pedidos.delete(10248); //no debería dejar borrarlos al ser campo clave y dependiente de otros campos
        assertEquals(result, 0);
    }

    /**
     * Test of listar method, of class PedidosDao.
     */
    @Test
    public void testListar() {
        System.out.println("LISTAR");

        Integer posicion = -30;
        ArrayList<Pedido> result = new ArrayList<>();
        result = pedidos.listar(posicion);
        //al ser negativo debe de dar una arraylist vacía (no sé expresarlo)
        assertNotEquals(result, null);

        posicion = 0;
        result = pedidos.listar(posicion);
        //la arrayList no es nula (no sé expresarlo) por lo que ahora tiene los pedidos
        assertNotEquals(result, null);
    }
    

//    DESCONOZCO CÓMO HACER EL DEL UPDATE AL TENER QUE ACCEDER AL MENÚ
//    /**
//     * Test of update method, of class PedidosDao.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Pedido pedido = null;
//        PedidosDao instance = new PedidosDao();
//        Integer expResult = null;
//        Integer result = instance.update(pedido);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
