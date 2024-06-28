package api.enginner_peti9.entity.enums;

public enum VacinaTipos {
    CINOMOSE("Cinomose"),
    PARVOVIROSE("Parvovirose"),
    CORONAVIROSE("Coronavirose"),
    ADENOVIROSE("Adenovirose"),
    OUTRO("Outro");

    private final String valor;

    VacinaTipos(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static boolean contemValor(String valor) {
        for (VacinaTipos valorEnumeracao : values()) {
            if (valorEnumeracao.getValor().equals(valor)) {
                return true;
            }
        }
        return false;
    }
}
