package Domain;

import java.math.BigDecimal;

public class CCN {
    
     private int id;
     private String intestatario;
     private String dataapertura;
     private BigDecimal saldo;

    public CCN(int id, String intestatario, String dataapertura, BigDecimal saldo) {
        this.id = id;
        this.intestatario = intestatario;
        this.dataapertura = dataapertura;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CCN{" + "id=" + id + ", intestatario=" + intestatario + ", dataapertura=" + dataapertura + ", saldo=" + saldo + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(String intestatario) {
        this.intestatario = intestatario;
    }

    public String getDataapertura() {
        return dataapertura;
    }

    public void setDataapertura(String dataapertura) {
        this.dataapertura = dataapertura;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
