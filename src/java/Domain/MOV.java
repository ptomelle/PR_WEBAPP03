package Domain;

import java.math.BigDecimal;


public class MOV {
    private int id;
    private int codintest;
    private String descr;
    private int coddest;
    private BigDecimal importo;  
    private String data;

    public MOV(int id, int codintest, String descr, int coddest, BigDecimal importo, String data) {
        this.id = id;
        this.codintest = codintest;
        this.descr = descr;
        this.coddest = coddest;
        this.importo = importo;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MOV{" + "id=" + id + ", codintest=" + codintest + ", descr=" + descr + ", coddest=" + coddest + ", importo=" + importo + ", data=" + data + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodintest() {
        return codintest;
    }

    public void setCodintest(int codintest) {
        this.codintest = codintest;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getCoddest() {
        return coddest;
    }

    public void setCoddest(int coddest) {
        this.coddest = coddest;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
