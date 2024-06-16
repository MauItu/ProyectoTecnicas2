package co.edu.konradlorenz.modelo;

public class Cliente extends Persona {
    private String nombreHospital;
    private String direccion;
    private String tipoMantenimiento;
    private int cantMante;
    private String telHospital;

    public Cliente(String nombre, String cedula, String nombreHospital, String direccion, String tipoMantenimiento, int cantMante, String telHospital) {
        super(nombre, cedula);
        this.nombreHospital = nombreHospital;
        this.direccion = direccion;
        this.tipoMantenimiento = tipoMantenimiento;
        this.cantMante = cantMante;
        this.telHospital = telHospital;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public int getCantMante() {
        return cantMante;
    }

    public String getTelHospital() {
        return telHospital;
    }
}
