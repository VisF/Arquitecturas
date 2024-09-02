package Modelo;

public class Producto {
	private int idProducto;
	private String nombre;
	private float valor;
	
	public Producto() {
		super();
	}
	
	public Producto (int id, String nombre, float valor) {
		this.idProducto=id;
		this.nombre = nombre;
		this.valor = valor;	
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "Producto [idProducto=" + this.getIdProducto() + ", nombre=" + this.getNombre() + ", valor=" + this.getValor() + "]";
	}
	
}
