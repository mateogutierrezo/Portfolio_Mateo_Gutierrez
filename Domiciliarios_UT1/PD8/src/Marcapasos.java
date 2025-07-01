public class Marcapasos {
    private short presionSanguinea;
    private short frecuenciaCardiaca;
    private int nivelAzucar;
    private long maximaFuerza;
    private float minimoTiempoEntreLatidos;
    private double bateriaRestante;
    private String codigoFabricante;

    public Marcapasos(short presionSanguinea, short frecuenciaCardiaca, int nivelAzucar, 
                      long maximaFuerza, float minimoTiempoEntreLatidos, double bateriaRestante, 
                      String codigoFabricante) {
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucar = nivelAzucar;
        this.maximaFuerza = maximaFuerza;
        this.minimoTiempoEntreLatidos = minimoTiempoEntreLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }
    
    public short getPresionSanguinea() {
        return presionSanguinea;
    }
    
    public void setPresionSanguinea(byte presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }
    
    public short getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }
    
    public void setFrecuenciaCardiaca(short frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }
    
    public int getNivelAzucar() {
        return nivelAzucar;
    }
    
    public void setNivelAzucar(int nivelAzucar) {
        this.nivelAzucar = nivelAzucar;
    }
    
    public long getMaximaFuerza() {
        return maximaFuerza;
    }
    
    public void setMaximaFuerza(long maximaFuerza) {
        this.maximaFuerza = maximaFuerza;
    }
    
    public float getMinimoTiempoEntreLatidos() {
        return minimoTiempoEntreLatidos;
    }
    
    public void setMinimoTiempoEntreLatidos(float minimoTiempoEntreLatidos) {
        this.minimoTiempoEntreLatidos = minimoTiempoEntreLatidos;
    }
    
    public double getBateriaRestante() {
        return bateriaRestante;
    }
    
    public void setBateriaRestante(double bateriaRestante) {
        this.bateriaRestante = bateriaRestante;
    }
    
    public String getCodigoFabricante() {
        return codigoFabricante;
    }
    
    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }
}
