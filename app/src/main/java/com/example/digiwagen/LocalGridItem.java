package com.example.digiwagen;

import android.widget.AdapterView;

public class LocalGridItem {
    private String nomeLocal;
    private String descricaoLocal;

    private String mensagemClick;

    public LocalGridItem(String nomeLocal, String descricaoLocal, String mensagemClick) {
        this.nomeLocal = nomeLocal;
        this.descricaoLocal = descricaoLocal;
        this.mensagemClick = mensagemClick;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public String getMensagemClick() {
        return mensagemClick;
    }

    public void setMensagemClick(String mensagemClick) {
        this.mensagemClick = mensagemClick;
    }
}
