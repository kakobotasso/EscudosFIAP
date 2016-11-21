package br.com.kakobotasso.escudosfiap.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Escudo implements Parcelable {
    private String nome;
    private String estado;

    @SerializedName("escudo")
    private String imagem;

    @SerializedName("anofundacao")
    private int fundacao;

    protected Escudo(Parcel in) {
        nome = in.readString();
        estado = in.readString();
        imagem = in.readString();
        fundacao = in.readInt();
    }

    public static final Creator<Escudo> CREATOR = new Creator<Escudo>() {
        @Override
        public Escudo createFromParcel(Parcel in) {
            return new Escudo(in);
        }

        @Override
        public Escudo[] newArray(int size) {
            return new Escudo[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getFundacao() {
        return fundacao;
    }

    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }

    public String getTextoFundacao(){
        return String.valueOf(getFundacao());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(estado);
        parcel.writeString(imagem);
        parcel.writeInt(fundacao);
    }
}
