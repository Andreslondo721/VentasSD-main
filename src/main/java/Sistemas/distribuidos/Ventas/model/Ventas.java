package Sistemas.distribuidos.Ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table(name = "ventas")
public class Ventas {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
    private String codigo_producto;
    private int cantidad;
    private String NIT_cliente;


    public Ventas() {
    }


    public Ventas(String codigo_producto, int cantidad, String NIT_cliente) {
        
        this.codigo_producto = codigo_producto;
        this.cantidad = cantidad;
        this.NIT_cliente = NIT_cliente;
    }

    /**
     * Obtiene el identificador de la venta.
     * @return El ID de la venta.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador de la venta.
     * @param id Nuevo ID de la venta.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el código del producto vendido.
     * @return Código del producto.
     */
    public String getCodigo_producto() {
        return codigo_producto;
    }

    /**
     * Establece el código del producto vendido.
     * @param codigo_producto Nuevo código del producto.
     */
    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    /**
     * Obtiene la cantidad de productos vendidos.
     * @return Cantidad de productos vendidos.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos vendidos.
     * @param cantidad Nueva cantidad de productos vendidos.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el NIT del cliente.
     * @return NIT del cliente.
     */
    public String getNIT_cliente() {
        return NIT_cliente;
    }

    /**
     * Establece el NIT del cliente.
     * @param NIT_cliente Nuevo NIT del cliente.
     */
    public void setNIT_cliente(String NIT_cliente) {
        this.NIT_cliente = NIT_cliente;
    }
}

